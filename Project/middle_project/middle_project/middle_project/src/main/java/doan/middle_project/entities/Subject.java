package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "subject_code", columnDefinition = "varchar(250)")
    private String subjectCode;

    @Column(name = "subject_name", columnDefinition = "longtext")
    private String subjectName;

    @Column(name = "subject_note", columnDefinition = "longtext")
    private String subjectNote;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "prerequisite", columnDefinition = "longtext")
    private String preRequisite;

    @Column(name = "status")
    private Integer status;

//    @ManyToOne
//    @JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id", nullable = false)
//    private Curriculum curriculum;

    @ManyToMany (mappedBy = "subjectId",cascade = {CascadeType.MERGE})
    private Set<Curriculum> curriculumId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subject_PLO", joinColumns = @JoinColumn(name = "subjectId"),
            inverseJoinColumns = @JoinColumn(name = "ploId"))
    private List<PLO> ploId;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Material> material;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CLO> clo;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sessions> sessions;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Assessment> assessment;

    @OneToMany( mappedBy = "subject_code",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PreRequisite> subject_code;

    @OneToMany( mappedBy = "requisite_subject_code",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PreRequisite> requisite_subject_code;
}
