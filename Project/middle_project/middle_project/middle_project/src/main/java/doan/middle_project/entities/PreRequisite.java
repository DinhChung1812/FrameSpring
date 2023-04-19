package doan.middle_project.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "pre_requisite")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

public class PreRequisite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_requisite_id")
    private Integer preRequisiteId;

//    @Column(name = "subject_code", columnDefinition = "longtext")
//    private String subject_code;

//    @Column(name = "requisite_subject_code", columnDefinition = "longtext")
//    private String requisite_subject_code;

    @ManyToOne
    @JoinColumn(name = "subjectCode", referencedColumnName = "subject_code", nullable = false)
    private Subject subject_code;

    @ManyToOne
    @JoinColumn(name = "requisiteSubjectCode", referencedColumnName = "subject_code", nullable = false)
    private Subject requisite_subject_code;

    @ManyToOne
    @JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id", nullable = false)
    private Curriculum curriculum;

}
