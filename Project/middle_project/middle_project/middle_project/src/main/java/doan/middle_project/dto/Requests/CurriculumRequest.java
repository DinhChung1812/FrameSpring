package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class CurriculumRequest {

    private String curriculumCode;
    private String curriculumName;
    private String curriculumNameEnglish;
    private String description;
    private String descriptionNO;
    private Integer status;
    private Integer decisionId;

}
