package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Assessment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Integer assessmentId;

    @Column(name = "assessment_category", columnDefinition = "longtext")
    private String assessment_category;

    @Column(name = "type", columnDefinition = "longtext")
    private String assessment;

    @Column(name = "part")
    private Integer part;

    @Column(name = "weight", columnDefinition = "longtext")
    private String weight;

    @Column(name = "completion_criteria", columnDefinition = "longtext")
    private String completionCriteria;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "question_type", columnDefinition = "longtext")
    private String questionType;

    @Column(name = "question_no", columnDefinition = "longtext")
    private String questionNo;

    @Column(name = "knowledge_skill", columnDefinition = "longtext")
    private String knowledgeSkill;

    @Column(name = "grading_guide", columnDefinition = "longtext")
    private String gradingGuide;

    @Column(name = "note", columnDefinition = "longtext")
    private String note;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;

}
