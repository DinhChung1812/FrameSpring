package doan.middle_project.service;

import doan.middle_project.dto.Responds.PloResponse;

import java.util.List;

public interface PloService {
    List<PloResponse> getListPlo(String CurriculumCode, Integer status);
}
