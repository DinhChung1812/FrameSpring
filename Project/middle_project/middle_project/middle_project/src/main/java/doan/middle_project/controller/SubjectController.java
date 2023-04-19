package doan.middle_project.controller;

import doan.middle_project.dto.Requests.SubjectRequest;
import doan.middle_project.dto.Responds.SubjectPloMappingResponse;
import doan.middle_project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/createSubject")
    public void createSubject(@RequestBody SubjectRequest subject){
        subjectService.createSubject(subject);
    }

//    @GetMapping("/getSubjectPlo")
//    public List<SubjectPloResponse> getSubjectPlo(@RequestParam("Curriculum_id") Integer curriculumId){
//        return subjectService.getSubjectPlo(curriculumId);
//    }

    @GetMapping("/getSubjectPlo")
    public List<SubjectPloMappingResponse> getSubjectPlo(@RequestParam("Curriculum_id") Integer curriculumId){
        return subjectService.getSubjectPlo2(curriculumId);
    }


}
