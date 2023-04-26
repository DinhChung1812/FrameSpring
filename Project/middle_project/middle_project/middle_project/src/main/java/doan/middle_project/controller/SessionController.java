package doan.middle_project.controller;

import doan.middle_project.dto.Requests.ElectiveRequest;
import doan.middle_project.dto.Requests.SessionRequest;
import doan.middle_project.service.QuestionService;
import doan.middle_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SessionController {
    @Autowired
    SessionService sessionService;

    @GetMapping("/get_all_session")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllSession(@RequestParam(required = false) Integer id_syllabus) {
        return sessionService.getAllSession(id_syllabus);
    }

    @GetMapping("/get_session_detail")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getSessionDetail(@RequestParam("id_session") Integer id_session) {
        return sessionService.getSessionDetail(id_session);
    }

    @PutMapping("/update_insert_session")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updateInsertSession(@RequestParam("session_id") Integer sessionId, @RequestBody SessionRequest sessionRequest){
        return sessionService.updateInsertSession(sessionId, sessionRequest);
    }

}
