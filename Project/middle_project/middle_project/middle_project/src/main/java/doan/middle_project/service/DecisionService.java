package doan.middle_project.service;

import doan.middle_project.dto.Requests.DecisionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;

public interface DecisionService {
    ResponseEntity<?> getAllDecision(String code_curriculum, String code_syllybus);
    ResponseEntity<?> updateOrInsertDecision(Integer decisionId, DecisionRequest decisionRequest) throws ParseException;
}
