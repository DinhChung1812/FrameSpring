package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class AssessmentRequest {
    private Integer syllabusId;
    private Integer assessmentCateId;

    private String assessment_category;

    private String type;

    private Integer part;

    private String weight;

    private String completionCriteria;

    private Integer duration;

    private String questionType;

    private String questionNo;

    private String knowledgeSkill;

    private String gradingGuide;

    private String note;
}
