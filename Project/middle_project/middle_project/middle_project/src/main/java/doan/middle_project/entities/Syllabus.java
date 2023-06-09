package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Syllabus")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Syllabus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "syllabus_id")
    private Integer syllabusId;

    @Column(name = "syllabus_name", columnDefinition = "longtext")
    private String syllabusName;

    @Column(name = "syllabus_description", columnDefinition = "longtext")
    private String syllabusDescription;

    @Column(name = "isActive")
    private Integer isActive;

    @Column(name = "isProved")
    private Integer isProved;

    @Column(name = "time_allocation")
    private String timeAllocation;

    @Column(name = "scoring_scale")
    private Integer scoringScale;

    @Column(name = "degree_level")
    private String degreeLevel;

    @Column(name = "student_task")
    private String studentTasks;

    @Column(name = "tool")
    private String tool;

    @Column(name = "min_Avg_Mark_To_Pass")
    private Integer minAvgMarkToPass;

    @Column(name = "note")
    private String note;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subjectId;

    @OneToOne(mappedBy = "syllabusId")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "decision_id", referencedColumnName = "decision_id", nullable = false)
    private Decision decision;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Syllabus_Assessment", joinColumns = @JoinColumn(name = "syllabusId"),
            inverseJoinColumns = @JoinColumn(name = "assessmentId"))
    private List<Assessment> assessmentId;

    @OneToMany( mappedBy = "syllabus",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sessions> sessions;
}
