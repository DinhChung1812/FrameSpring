package doan.middle_project.controller;

import doan.middle_project.dto.Requests.ProfileEditRequest;
import doan.middle_project.dto.Requests.ProfileRequest;
import doan.middle_project.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;




}
