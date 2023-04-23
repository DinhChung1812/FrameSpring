package doan.middle_project.service;

import org.springframework.http.ResponseEntity;

public interface SyllabusService {
    ResponseEntity<?> getSyllabusById(Integer id_syllabus);
}
