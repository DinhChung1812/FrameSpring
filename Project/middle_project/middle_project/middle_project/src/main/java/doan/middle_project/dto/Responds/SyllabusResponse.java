package doan.middle_project.dto.Responds;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class SyllabusResponse {
    private Integer syllabusId;
    private String syllabusName;
    private String subjectCode;
    private Integer noCredit;
    private String degreeLevel;
    private String timeAllocation;
    private List<String> PreRequisite;
    private String syllabusDescription;
    private String studentTasks;
    private String tool;
    private Integer scoringScale;
    private String decisionNo;
    private String note;
    private Integer minAvgMarkToPass;
    private Boolean isActive;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ApprovedDate;
}
