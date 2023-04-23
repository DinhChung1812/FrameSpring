package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Elective")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Elective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "elective_id")
    private Integer electiveId;

    @Column(name = "elective_code", columnDefinition = "longtext")
    private String electiveCode;

    @Column(name = "elective_name", columnDefinition = "longtext")
    private String electiveName;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id", nullable = false)
    private Curriculum curriculum;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;

}
