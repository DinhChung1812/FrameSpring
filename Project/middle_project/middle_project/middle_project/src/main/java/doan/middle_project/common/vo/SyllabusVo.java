package doan.middle_project.common.vo;

import lombok.Data;

import javax.persistence.Column;
import java.time.DateTimeException;
import java.util.Date;

@Data
public class SyllabusVo {
    private Integer syllabusId;
    private String subjectCode;
    private String subjectName;
    private String syllabusName;
    private Integer isActive;
    private Integer isProved;
    private Date decisionDate;
    private String decisionNo;
    private String decisionNoNew;
}
