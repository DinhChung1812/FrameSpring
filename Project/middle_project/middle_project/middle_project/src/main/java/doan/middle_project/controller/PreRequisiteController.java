package doan.middle_project.controller;

import doan.middle_project.dto.Responds.PreRequisiteDto;
import doan.middle_project.service.PreRequisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PreRequisiteController {

    @Autowired
    PreRequisiteService preRequisiteService;

    @GetMapping("/getPreRequisite")
    public List<PreRequisiteDto> getPreRequisite(@RequestParam("subject_code") String subjectCode){
       return preRequisiteService.getPreRequisite(subjectCode);
    }
}
