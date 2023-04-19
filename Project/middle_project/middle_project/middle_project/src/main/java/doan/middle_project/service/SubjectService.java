package doan.middle_project.service;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.SubjectVo;

import java.util.List;

public interface SubjectService {
    List<SubjectVo> getAllSubject(String code);
}
