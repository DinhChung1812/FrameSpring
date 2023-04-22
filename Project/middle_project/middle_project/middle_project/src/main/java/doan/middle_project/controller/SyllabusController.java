package doan.middle_project.controller;

import doan.middle_project.dto.Responds.SyllabusDto;
import doan.middle_project.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SyllabusController {

    @Autowired
    SyllabusService syllabusService;

    @GetMapping("/getSyllabusList")
    public List<SyllabusDto> getSyllabusList(@RequestParam("type")Integer type, @RequestParam("text_search") String textSearch ){
        return syllabusService.getSyllabusList(type,textSearch);
    }

}
