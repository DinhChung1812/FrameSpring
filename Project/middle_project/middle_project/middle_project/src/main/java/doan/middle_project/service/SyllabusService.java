package doan.middle_project.service;

import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface SyllabusService {
    ResponseEntity<?> getSyllabusById(Integer id_syllabus) throws ParseException;
}
