package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Curriculum")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id")
    private Integer curriculumId;

    @Column(name = "curriculum_code", columnDefinition = "longtext")
    private String curriculumCode;

    @Column(name = "curriculum_name", columnDefinition = "longtext")
    private String curriculumName;

    @Column(name = "curriculum_name_english", columnDefinition = "longtext")
    private String curriculumNameEnglish;

    @Column(name = "description", columnDefinition = "longtext")
    private String description;

    @Column(name = "description_no", columnDefinition = "longtext")
    private String descriptionNO;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total_credit")
    private Integer totalCredit;

//    @OneToMany( mappedBy = "curriculum",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Subject> subject;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Curriculum_Subject", joinColumns = @JoinColumn(name = "curriculumId"),
            inverseJoinColumns = @JoinColumn(name = "subjectId"))
    private List<Subject> subjectId;


    @OneToMany( mappedBy = "curriculum",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PO> po;

    @OneToMany( mappedBy = "curriculum",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PLO> plo;

    @OneToOne(mappedBy = "curriculumId")
    private Account account;

}
