package doan.middle_project.service;

import doan.middle_project.dto.Responds.CloPloMappingResponse;
import doan.middle_project.dto.Responds.CloResponse;

import java.util.List;

public interface CloService {
    List<CloResponse> getCloList();

    List<CloPloMappingResponse> getCloPloMapping(String subjectCode);
}
