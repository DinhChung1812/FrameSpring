package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class ElectiveRequest {
    private Integer curriculumId;
    private Integer subjectId;

    private String electiveCode;

    private String electiveName;

    private String subjectName;

    private String subjectCode;
}
