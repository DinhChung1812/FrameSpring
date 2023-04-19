package doan.middle_project.service;


import doan.middle_project.dto.Requests.SubjectRequest;
import doan.middle_project.dto.Responds.SubjectPloResponse;
import doan.middle_project.dto.Responds.SubjectPloMappingResponse;
import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.SubjectVo;


import java.util.List;

public interface SubjectService {

    void createSubject(SubjectRequest subject);

    List<SubjectPloResponse> getSubjectPlo(Integer curriculumId);

    List<SubjectPloMappingResponse> getSubjectPlo2(Integer curriculumId);

    List<SubjectVo> getAllSubject(String code);
}
