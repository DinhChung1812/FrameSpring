package doan.middle_project.controller;

import doan.middle_project.dto.Responds.PoResponse;
import doan.middle_project.service.PoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoController {

    @Autowired
    PoService poService;

    @GetMapping("/poDetail")
    public ResponseEntity<?> getPoDetail (@RequestParam(value = "curriculum_code",required = false,defaultValue = " ") String curriculumCode,
                                          @RequestParam(value = "status") Integer status){
        return poService.getPoDetail(curriculumCode,status);
    }

}
