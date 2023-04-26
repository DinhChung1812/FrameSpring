package doan.middle_project.controller;

import doan.middle_project.dto.Requests.QuestionRequest;
import doan.middle_project.dto.Requests.SessionRequest;
import doan.middle_project.service.AssessmentService;
import doan.middle_project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/get_all_question_by_session")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllQuestionBySession(@RequestParam(required = false) String sessionCode) {
        return questionService.getAllQuestionBySession(sessionCode);
    }

    @GetMapping("/get_question_detail")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getQuestionDetail(@RequestParam("id_question") Integer id_question) {
        return questionService.getQuestionDetail(id_question);
    }

    @PutMapping("/update_insert_question")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updateInsertQuestion(@RequestParam("id_question") Integer id_question, @RequestBody QuestionRequest questionRequest){
        return questionService.updateInsertQuestion(id_question, questionRequest);
    }
}
