package doan.middle_project.service;

import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

public interface PoService {
    ResponseEntity<?> getPoDetail(String curriculumCode);
}
