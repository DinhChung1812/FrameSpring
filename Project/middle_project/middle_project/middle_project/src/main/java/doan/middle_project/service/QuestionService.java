package doan.middle_project.service;

import org.springframework.http.ResponseEntity;

public interface QuestionService {
    ResponseEntity<?> getAllQuestion(String code);
}
