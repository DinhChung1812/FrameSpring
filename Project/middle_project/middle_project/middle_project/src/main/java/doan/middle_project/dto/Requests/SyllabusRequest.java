package doan.middle_project.dto.Requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SyllabusRequest {
    private String syllabusName;
    private String subjectCode;
    private String degreeLevel;
    private String timeAllocation;
    private String syllabusDescription;
    private String studentTasks;
    private String tool;
    private Integer scoringScale;
    private String decisionNo;
    private String note;
    private Integer minAvgMarkToPass;
    private Boolean isActive;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date ApprovedDate;

    private Boolean status;
}
