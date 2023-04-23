package doan.middle_project.controller;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.MessageVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.common.vo.POVo;
import doan.middle_project.dto.Requests.CuriculumEditRequest;
import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.service.CuriculumService;
import doan.middle_project.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SyllabusController {
    @Autowired
    SyllabusService syllabusService;

    @GetMapping("/get_syllabus_by_id")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getSyllabusById(@RequestParam("id_syllabus") Integer id_syllabus) {
        return syllabusService.getSyllabusById(id_syllabus);
    }
}
