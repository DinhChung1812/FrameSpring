package doan.middle_project.service;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.ElectiveVo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ElectiveService {
    ResponseEntity<?> getAllElective(String code);
}
