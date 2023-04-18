package doan.middle_project.controller;

import doan.middle_project.entities.Subject;
import doan.middle_project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/createSubject")
    public void createSubject(@RequestBody Subject subject){
//        subjectService.createSubject(subject);
    }

}
