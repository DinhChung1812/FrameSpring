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



}
