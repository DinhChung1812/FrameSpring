package doan.middle_project.dto.Responds;

import lombok.Data;

import java.util.List;

@Data
public class SubjectPloMappingResponse {
    private Integer subjectId;
    private String subjectCode;
    List<PloDto> ploDtoList;
}
