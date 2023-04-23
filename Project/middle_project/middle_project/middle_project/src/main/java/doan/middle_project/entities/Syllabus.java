package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "syllabus_code", columnDefinition = "longtext")
    private String syllabusCode;

    @Column(name = "syllabus_name", columnDefinition = "longtext")
    private String syllabusName;

    @Column(name = "syllabus_description", columnDefinition = "longtext")
    private String syllabusDescription;

    @Column(name = "syllabus_status")
    private Integer syllabusStatus;

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
}
