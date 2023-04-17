package doan.middle_project.controller;

import doan.middle_project.common.vo.ChangePasswordRequest;
import doan.middle_project.common.vo.MessageVo;
import doan.middle_project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

@Controller
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AccountService accountService;
    @PostMapping("/change_password")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> changePassword(Authentication authentication, @Valid @RequestBody ChangePasswordRequest changePasswordRequest)
            throws AccountNotFoundException {
        MessageVo message = new MessageVo();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        try {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userName = userDetails.getUsername();
            String password = userDetails.getPassword();
            boolean passChecker = passwordEncoder.matches(changePasswordRequest.getOldPassword(), password);
            if(passChecker) {
                accountService.changePassword(userName, changePasswordRequest.getNewPassword());
                message.setMessContent("Mật khẩu đã được thay đổi");
                message.setMessType("success");
            }else{
                message.setMessContent("Mật khẩu cũ không đúng, xin hãy nhập lại");
                message.setMessType("error");
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }

        } catch (AccountNotFoundException ex) {
            message.setMessContent("Account not found");
            message.setMessType("error");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            message.setMessContent("Error while change password");
            message.setMessType("error");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
