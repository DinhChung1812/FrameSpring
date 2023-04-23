package doan.middle_project.service;

import doan.middle_project.dto.Requests.AssessmentRequest;
import doan.middle_project.dto.Requests.DecisionRequest;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface AssessmentService {
    ResponseEntity<?> getAllAssessment(String code);
    ResponseEntity<?> getAllAssessmentCate(Integer id_syllabus);

    ResponseEntity<?> UpdateInsertAssessment(Integer assessmentId, AssessmentRequest assessmentRequest);
}
