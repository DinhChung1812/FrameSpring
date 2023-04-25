package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany (mappedBy = "electiveId",cascade = {CascadeType.MERGE})
    private Set<Curriculum> curriculumId;

    @OneToMany( mappedBy = "elective",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subject> subject;
}
