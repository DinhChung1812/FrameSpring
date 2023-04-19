package doan.middle_project.service;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.dto.Requests.CuriculumEditRequest;
import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.exception.BadRequestException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CuriculumService {

    void createCurriculum(CurriculumRequest curriculumRequest);

    List<CuriculumVo> getAllCuriculum(String code);
    ResponseEntity<?> addOrEditCuriculum(Integer curiculumId, CuriculumEditRequest curiculumEditRequest) throws BadRequestException;
    ResponseEntity<?> deleteCuriculum(Integer curiculumId);
}
