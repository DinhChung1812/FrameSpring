package doan.middle_project.controller;

import doan.middle_project.service.QuestionService;
import doan.middle_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @Autowired
    SessionService sessionService;

    @GetMapping("/get_all_session")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllAssessment(@RequestParam(required = false) String code_syllabus) {
        return sessionService.getAllSession(code_syllabus);
    }
}
