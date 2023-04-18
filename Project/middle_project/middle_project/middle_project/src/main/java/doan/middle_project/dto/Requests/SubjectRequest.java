package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class SubjectRequest {
    private String subjectCode;
    private String subjectName;
    private String subjectNote;
    private Integer semester;
    private Integer credit;
    private String preRequisite;
    private Integer status;
    private String curriculumCode;
}
