package doan.middle_project.service;

import org.springframework.http.ResponseEntity;

public interface PoService {
    ResponseEntity<?> getPoDetail(String curriculumCode, Integer status);
}
