package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "po_id")
    private Integer poId;

    @Column(name = "po_name", columnDefinition = "longtext")
    private String poName;

    @Column(name = "po_description", columnDefinition = "longtext")
    private String poDescription;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id", nullable = false)
    private Curriculum curriculum;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PO_PLO", joinColumns = @JoinColumn(name = "poId"),
            inverseJoinColumns = @JoinColumn(name = "ploId"))
    private List<PLO> ploId;
}
