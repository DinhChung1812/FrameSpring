package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "curriculum_code", columnDefinition = "longtext")
    private String syllabusCode;

    @Column(name = "curriculum_name", columnDefinition = "longtext")
    private String syllabusName;

    @Column(name = "curriculum_description", columnDefinition = "longtext")
    private String syllabusDescription;

    @Column(name = "syllabus_status")
    private Integer syllabusStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subjectId;
}
