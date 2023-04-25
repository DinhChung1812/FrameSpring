package doan.middle_project.service;

import doan.middle_project.dto.Requests.ElectiveRequest;
import org.springframework.http.ResponseEntity;

public interface ElectiveService {
    ResponseEntity<?> getAllSubjectByElectiveId(Integer electiveId);
    ResponseEntity<?> getElectiveByCurriCode(String curriCode);

    ResponseEntity<?> updateInsertElective(Integer electiveId, ElectiveRequest electiveRequest);
}
