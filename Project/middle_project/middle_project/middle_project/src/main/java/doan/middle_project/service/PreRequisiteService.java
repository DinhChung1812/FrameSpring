package doan.middle_project.service;

import doan.middle_project.dto.Responds.PreRequisiteDto;

import java.util.List;

public interface PreRequisiteService {
    List<PreRequisiteDto> getPreRequisite(String subjectCode);
}
