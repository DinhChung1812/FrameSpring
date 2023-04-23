package doan.middle_project.controller;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.MessageVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.common.vo.POVo;
import doan.middle_project.dto.Requests.AssessmentRequest;
import doan.middle_project.dto.Requests.CuriculumEditRequest;
import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.dto.Requests.ElectiveRequest;
import doan.middle_project.service.CuriculumService;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElectiveController {
    @Autowired
    ElectiveService electiveService;

    @GetMapping("/get_all_elective")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllElective(@RequestParam(required = false) String code) {
        return electiveService.getAllElective(code);
    }

    @GetMapping("/get_elective_by_id")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getElectiveById(@RequestParam("elective_id") Integer electiveId) {
        return electiveService.getElectiveById(electiveId);
    }

    @PutMapping("/update_insert_elective")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updateInsertElective(@RequestParam("elective_id") Integer electiveId, @RequestBody ElectiveRequest electiveRequest){
        return electiveService.updateInsertElective(electiveId, electiveRequest);
    }
}
