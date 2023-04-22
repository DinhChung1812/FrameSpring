package doan.middle_project.dto.Responds;

import lombok.Data;

@Data
public class SyllabusDto {
    private Integer syllabusId;
    private String subjectCode;
    private String subjectName;
    private String syllabusName;
    private Boolean isActive;
    private Boolean isProved;
    private String decisionNo;
}
