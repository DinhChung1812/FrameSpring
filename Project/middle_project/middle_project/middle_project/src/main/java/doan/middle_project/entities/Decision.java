package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Decision")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decision_id")
    private Integer decisionId;

    @Column(name = "decision_no", columnDefinition = "longtext")
    private String decisionNo;

    @Column(name = "decision_date")
    private Date decisionDate;

    @OneToMany( mappedBy = "decision",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Curriculum> curriculum;

    @OneToMany( mappedBy = "decision",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Syllabus> syllabus;
}
