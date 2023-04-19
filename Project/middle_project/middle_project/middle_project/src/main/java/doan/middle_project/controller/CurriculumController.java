package doan.middle_project.controller;

import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.dto.Responds.CurriculumResponse;
import doan.middle_project.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurriculumController {

    @Autowired
    CurriculumService curriculumService;

    @PostMapping("/createCurriculum")
    public void createCurriculum(@RequestBody CurriculumRequest curriculumRequest){
        curriculumService.createCurriculum(curriculumRequest);
    }

    @GetMapping("/curriculumDetail")
    public CurriculumResponse curriculumDetail(@RequestParam("curriculum_id") Integer curriculumId){
        return curriculumService.curriculumDetail(curriculumId);
    }

}
