package doan.middle_project.controller;

import doan.middle_project.dto.Requests.AssessmentRequest;
import doan.middle_project.dto.Requests.DecisionRequest;
import doan.middle_project.service.AssessmentService;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class AssessmentController {
    @Autowired
    AssessmentService assessmentService;

    @GetMapping("/get_all_assessment")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllAssessment(@RequestParam(required = false) String code_syllabus) {
        return assessmentService.getAllAssessment(code_syllabus);
    }

    @PutMapping("/update_insert_assessment")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> UpdateInsertAssessment(@RequestParam("assessment_id") Integer assessmentId, @RequestBody AssessmentRequest assessmentRequest){
        return assessmentService.UpdateInsertAssessment(assessmentId, assessmentRequest);
    }
}
