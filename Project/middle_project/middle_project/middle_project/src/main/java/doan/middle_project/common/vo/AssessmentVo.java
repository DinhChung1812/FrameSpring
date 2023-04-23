package doan.middle_project.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentVo {

    private Integer assessmentId;

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
