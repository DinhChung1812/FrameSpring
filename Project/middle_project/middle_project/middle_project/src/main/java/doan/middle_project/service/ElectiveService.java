package doan.middle_project.service;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.dto.Requests.AssessmentRequest;
import doan.middle_project.dto.Requests.ElectiveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ElectiveService {
    ResponseEntity<?> getAllElective(String code);
    ResponseEntity<?> getElectiveById(Integer electiveId);

    ResponseEntity<?> updateInsertElective(Integer electiveId, ElectiveRequest electiveRequest);
}
