package doan.middle_project.dto.Responds;

import lombok.Data;

import java.util.List;

@Data public class PoResponse {

    private String curriculumCode;
    private String curriculumName;
    private List<PoDto> poDtoList;

}
