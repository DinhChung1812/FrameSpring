package doan.middle_project.controller;

import doan.middle_project.dto.Requests.SyllabusRequest;
import doan.middle_project.dto.Responds.SyllabusDto;
import doan.middle_project.dto.Responds.SyllabusResponse;
import doan.middle_project.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

import java.text.ParseException;
import java.util.List;

@RestController
public class SyllabusController {

    @Autowired
    SyllabusService syllabusService;

    @GetMapping("/getSyllabusList")
    public List<SyllabusDto> getSyllabusList(@RequestParam("type")Integer type, @RequestParam(value = "text_search",required = false,defaultValue = "") String textSearch ){
        return syllabusService.getSyllabusList(type,textSearch);
    }

    @PostMapping("/addSyllabus")
    public void addSyllabus(@RequestBody SyllabusRequest syllabusRequest){
        syllabusService.addSyllabus(syllabusRequest);
    }

    @PutMapping("/editSyllabus")
    public void editSyllabus(@RequestBody SyllabusRequest syllabusRequest, @RequestParam("syllabus_id")Integer syllabusId){
        syllabusService.editSyllabus(syllabusRequest,syllabusId);
    }

    @GetMapping("/syllabusDetail")
    public SyllabusResponse syllabusDetail(@RequestParam("syllabus_id")Integer syllabusId){
        return syllabusService.getSyllabusDetail(syllabusId);
    }


    @GetMapping("/get_syllabus_by_id")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getSyllabusById(@RequestParam(required = false) Integer id_syllabus) throws ParseException {
        return syllabusService.getSyllabusById(id_syllabus);
    }
}
