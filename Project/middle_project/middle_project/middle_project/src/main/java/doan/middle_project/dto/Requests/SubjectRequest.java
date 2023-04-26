package doan.middle_project.dto.Requests;

import lombok.Data;
import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.SqlResultSetMapping;


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
    private Integer electiveId;
    private Integer curriculumId;
}
