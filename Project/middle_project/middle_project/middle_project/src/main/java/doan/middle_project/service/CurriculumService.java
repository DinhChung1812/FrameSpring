package doan.middle_project.service;


import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.dto.Responds.CurriculumResponse;

public interface CurriculumService {
    void createCurriculum(CurriculumRequest curriculumRequest);

    CurriculumResponse curriculumDetail(Integer curriculumId);
}
