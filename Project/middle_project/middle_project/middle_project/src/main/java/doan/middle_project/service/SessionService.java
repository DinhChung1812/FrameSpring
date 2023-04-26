package doan.middle_project.service;

import doan.middle_project.dto.Requests.SessionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface SessionService {
    ResponseEntity<?> getAllSession(String code_syllabus);
    ResponseEntity<?> getSessionDetail(Integer id_session);
    ResponseEntity<?> updateInsertSession(Integer sessionId, SessionRequest sessionRequest);
}
