package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CLO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class CLO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clo_id")
    private Integer cloId;

    @Column(name = "clo_name", columnDefinition = "longtext")
    private String cloName;

    @Column(name = "clo_description", columnDefinition = "longtext")
    private String cloDescription;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;
}
