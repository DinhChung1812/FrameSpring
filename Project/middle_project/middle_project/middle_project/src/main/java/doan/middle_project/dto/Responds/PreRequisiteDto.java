package doan.middle_project.dto.Responds;

import lombok.Data;

import java.util.List;

@Data
public class PreRequisiteDto {
    private Integer syllabusId;
    private String subjectCode;
    private String syllabusName;
    private String decisionNo;
    private List<String> learnAfter;
}
