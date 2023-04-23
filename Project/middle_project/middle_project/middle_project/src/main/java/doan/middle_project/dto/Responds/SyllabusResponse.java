package doan.middle_project.dto.Responds;

import lombok.Data;

import java.util.Date;

@Data
public class SyllabusResponse {
    private Integer syllabusId;
    private String syllabusName;
    private String subjectCode;
    private Integer noCredit;
    private String degreeLevel;
    private String timeAllocation;
    private String PreRequisite;
    private String syllabusDescription;
    private String studentTasks;
    private String tool;
    private Integer scoringScale;
    private String decisionNo;
    private Boolean isProved;
    private String note;
    private Integer minAvgMarkToPass;
    private Boolean isActive;
    private Date ApprovedDate;
}
