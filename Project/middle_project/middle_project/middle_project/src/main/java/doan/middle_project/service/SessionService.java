package doan.middle_project.service;

import org.springframework.http.ResponseEntity;

public interface SessionService {
    ResponseEntity<?> getAllSession(String code);
}
