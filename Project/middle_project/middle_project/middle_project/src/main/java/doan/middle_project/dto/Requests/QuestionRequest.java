package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class QuestionRequest {
    private Integer sessionId;

    private String questionsName;

    private String questionsDetail;
}
