package doan.middle_project.service;

import doan.middle_project.dto.Responds.SyllabusDto;

import java.util.List;

public interface SyllabusService {
    List<SyllabusDto> getSyllabusList(Integer type, String textSearch);
}
