package doan.middle_project.service;

import doan.middle_project.dto.Requests.QuestionRequest;
import doan.middle_project.dto.Requests.SessionRequest;
import org.springframework.http.ResponseEntity;

public interface QuestionService {
    ResponseEntity<?> getAllQuestionBySession(String code);
    ResponseEntity<?> getQuestionDetail(Integer id_question);
    ResponseEntity<?> updateInsertQuestion(Integer id_question, QuestionRequest questionRequest);
}
