package doan.middle_project.service;

import org.springframework.http.ResponseEntity;

public interface AssessmentService {
    ResponseEntity<?> getAllAssessment(String code);
}
