package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PLO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class PLO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plo_id")
    private Integer ploId;

    @Column(name = "plo_name", columnDefinition = "longtext")
    private String ploName;

    @Column(name = "plo_description", columnDefinition = "longtext")
    private String ploDescription;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id", nullable = false)
    private Curriculum curriculum;

    @ManyToMany (mappedBy = "ploId",cascade = {CascadeType.MERGE})
    private Set<PO> poId;

    @ManyToMany (mappedBy = "ploId",cascade = {CascadeType.MERGE})
    private Set<CLO> clos;

    @ManyToMany (mappedBy = "ploId",cascade = {CascadeType.MERGE})
    private Set<Subject> subjectId;
}
