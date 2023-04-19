package doan.middle_project.controller;

import doan.middle_project.dto.Requests.ProfileEditRequest;
import doan.middle_project.dto.Requests.ProfileRequest;
import doan.middle_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/getprofile")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<ProfileRequest> getUserProfile(@RequestParam("account_id") Integer accountId) {
        ProfileRequest profileRequest = homeService.getProfile(accountId);
        return ResponseEntity.ok(profileRequest);
    }

    @GetMapping("/admin/get_account_detail")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProfileRequest> getAccountDetail(@RequestParam("account_id") Integer accountId) {
        ProfileRequest profileRequest = homeService.getProfile(accountId);
        return ResponseEntity.ok(profileRequest);
    }

    @PutMapping("/updateprofile")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> UpdateProfile(@RequestParam("account_id") Integer accountId, @RequestBody ProfileEditRequest profileRequest)  {
        return homeService.updateProfile(accountId, profileRequest);
    }

    @PutMapping("/updateimage")
    @PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_MOD')or hasRole('ROLE_USER')")
    public ResponseEntity<?> updateImage(@RequestParam("profile_id") Integer profileId,@RequestBody String image){
        return homeService.updateImage(profileId,image);
    }
}
