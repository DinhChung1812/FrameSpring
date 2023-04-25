package doan.middle_project.service;

import doan.middle_project.dto.Requests.SyllabusRequest;
import doan.middle_project.dto.Responds.SyllabusDto;
import doan.middle_project.dto.Responds.SyllabusResponse;
import org.springframework.http.ResponseEntity;
import java.text.ParseException;

import java.util.List;

public interface SyllabusService {
    List<SyllabusDto> getSyllabusList(Integer type, String textSearch);

    void addSyllabus(SyllabusRequest syllabusRequest);

    void editSyllabus(SyllabusRequest syllabusRequest, Integer syllabusId);

    SyllabusResponse getSyllabusDetail(Integer syllabusId);

    ResponseEntity<?> getSyllabusById(Integer id_syllabus) throws ParseException;
}
