package doan.middle_project.controller;

import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurriculumController {

    @Autowired
    CurriculumService curriculumService;

    @PostMapping("/createCurriculum")
    public void createCurriculum(@RequestBody CurriculumRequest curriculumRequest){
        curriculumService.createCurriculum(curriculumRequest);
    }

}
