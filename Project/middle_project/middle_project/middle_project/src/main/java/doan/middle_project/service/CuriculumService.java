package doan.middle_project.service;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.common.vo.POVo;
import doan.middle_project.dto.Requests.CuriculumEditRequest;

import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.exception.BadRequestException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CuriculumService {

    ResponseEntity<?> createCurriculum(Integer curriculumId,CurriculumRequest curriculumRequest);
    ResponseEntity<?> getAllCuriculum(String code);
    ResponseEntity<?> addOrEditCuriculum(Integer curiculumId, CuriculumEditRequest curiculumEditRequest) throws BadRequestException;
    ResponseEntity<?> updateTotalCreditCuriculum (Integer curiculumId) throws BadRequestException;
    ResponseEntity<?> deleteCuriculum(Integer curiculumId);
    List<PLOVo> getAllPLO(String code);
    List<POVo> getAllPO(String code);
}
