package doan.middle_project.dto.Responds;

import lombok.Data;

import javax.persistence.Column;
@Data
public class QuestionResponse {
    private Integer questionsId;

    private String questionsName;

    private String questionsDetail;
}
