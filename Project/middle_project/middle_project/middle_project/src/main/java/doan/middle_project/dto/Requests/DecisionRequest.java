package doan.middle_project.dto.Requests;

import lombok.Data;

import java.util.Date;

@Data
public class DecisionRequest {
    private Integer decisionId;

    private String decisionNo;

    private String decisionDate;

    private String note;

    private String createDate;

    private String fileName;

    private String decisionNewName;
}
