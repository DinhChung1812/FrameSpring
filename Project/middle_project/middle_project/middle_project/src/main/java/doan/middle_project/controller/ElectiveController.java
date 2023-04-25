package doan.middle_project.controller;

import doan.middle_project.dto.Requests.ElectiveRequest;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ElectiveController {
    @Autowired
    ElectiveService electiveService;

    @GetMapping("/get_all_subject_elective")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllSubjectByElectiveId(@RequestParam(required = false) Integer electiveId) {
        return electiveService.getAllSubjectByElectiveId(electiveId);
    }

    @GetMapping("/get_elective_by_curriCode")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getElectiveByCurriCode(@RequestParam(required = false) String curriCode) {
        return electiveService.getElectiveByCurriCode(curriCode);
    }

    @PutMapping("/update_insert_elective")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updateInsertElective(@RequestParam("elective_id") Integer electiveId, @RequestBody ElectiveRequest electiveRequest){
        return electiveService.updateInsertElective(electiveId, electiveRequest);
    }
}
