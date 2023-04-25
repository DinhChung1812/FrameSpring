package doan.middle_project.controller;

import doan.middle_project.dto.Requests.DecisionRequest;
import doan.middle_project.dto.Requests.ProfileEditRequest;
import doan.middle_project.service.DecisionService;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class DecisionController {
    @Autowired
    DecisionService decisionService;

    @GetMapping("/get_all_decision")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllDecision(@RequestParam(required = false) String code_curriculum, @RequestParam(required = false) String code_syllybus) {
        return decisionService.getAllDecision(code_curriculum, code_syllybus);
    }

    @GetMapping("/get_decision_by_id")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getDecisionById(@RequestParam("decision_id") Integer decisionId) {
        return decisionService.getDecisionById(decisionId);
    }

    @PutMapping("/update_insert_decision")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updateOrInsertDecision(@RequestParam("decision_id") Integer decisionId, @RequestBody DecisionRequest decisionRequest) throws ParseException {
        return decisionService.updateOrInsertDecision(decisionId, decisionRequest);
    }
}
