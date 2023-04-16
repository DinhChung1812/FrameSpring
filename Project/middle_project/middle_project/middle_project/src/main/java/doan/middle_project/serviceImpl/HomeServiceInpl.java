package doan.middle_project.serviceImpl;

import doan.middle_project.exception.StatusCode;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.dto.Requests.ProfileEditRequest;
import doan.middle_project.dto.Requests.ProfileRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.repositories.AccountRepository;
import doan.middle_project.service.HomeService;
import doan.middle_project.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HomeServiceInpl implements HomeService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public ProfileRequest getProfile(Integer profileId) throws NotFoundException {
        Account account = accountRepository.findById(profileId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy người dùng!!!"));
        ProfileRequest request = new ProfileRequest();
        request.setAccountId(account.getAccountId());
        request.setName(account.getFullname());
        request.setUserName(account.getUserName());
        request.setJob_Title(account.getJobTitle());
        request.setCompany(account.getCompany());
        request.setEmail(account.getEmail());
        request.setTitle(account.getTitle());
        request.setPhone(account.getPhone());
        request.setRole(account.getRole());
        request.setAvatarImage(account.getAvatarImage());
        return request;
    }

    @Override
    public ResponseEntity<?> updateProfile(Integer profileId, ProfileEditRequest profileRequest) throws NotFoundException {
        Account account = accountRepository.findById(profileId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy người dùng!!!"));
        account.setJobTitle(profileRequest.getJobTitle());
        account.setCompany(profileRequest.getCompany());
        account.setEmail(profileRequest.getEmail());
        account.setTitle(profileRequest.getTitle());
        account.setPhone(profileRequest.getPhone());
        account.setAvatarImage(profileRequest.getAvatarImage());
        accountRepository.save(account);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,"Cập nhật profile thành công"));
    }

    @Override
    public ResponseEntity<?> updateImage(Integer profileId, String image) {
        Account a = accountRepository.findById(profileId).orElseThrow(()->new NotFoundException(StatusCode.Not_Found,"Tài khoản đã bị khóa hoặc không tìm thấy"));
        a.setAvatarImage(image);
        accountRepository.save(a);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,"Cập nhật ảnh thành công"));
    }
}
