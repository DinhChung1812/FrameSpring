package doan.middle_project.controller;

import doan.middle_project.dto.Requests.SubjectRequest;
import doan.middle_project.dto.Responds.SubjectPloMappingResponse;
import doan.middle_project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.MessageVo;
import doan.middle_project.common.vo.SubjectVo;
import doan.middle_project.entities.Subject;
import doan.middle_project.service.CuriculumService;
import doan.middle_project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/update_create_subject")
    public ResponseEntity<?> updateCreateSubject(@RequestParam(required = false) Integer subjectId, @RequestBody SubjectRequest subjectRequest){
        return subjectService.createSubject(subjectId, subjectRequest);
    }

//    @GetMapping("/getSubjectPlo")
//    public List<SubjectPloResponse> getSubjectPlo(@RequestParam("Curriculum_id") Integer curriculumId){
//        return subjectService.getSubjectPlo(curriculumId);
//    }

    @GetMapping("/getSubjectPlo")
    public List<SubjectPloMappingResponse> getSubjectPlo(@RequestParam("Curriculum_id") Integer curriculumId){
        return subjectService.getSubjectPlo2(curriculumId);
    }
    @GetMapping("/get_all_subject")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllSubject(@RequestParam(required = false) String code) {
        List<SubjectVo> listSubject = subjectService.getAllSubject(code);
        if (listSubject == null){
            return ResponseEntity.ok(new MessageVo("Không tồn tại subject nào!!!", "Infor"));
        }
        return ResponseEntity.ok(listSubject);
    }

    @GetMapping("/get_all_subject_not_elective")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllSubjectNotElective() {
        List<SubjectVo> listSubject = subjectService.getAllSubjectNotElective();
        if (listSubject == null){
            return ResponseEntity.ok(new MessageVo("Không tồn tại subject nào có electiveId null!!!", "Infor"));
        }
        return ResponseEntity.ok(listSubject);
    }
}
