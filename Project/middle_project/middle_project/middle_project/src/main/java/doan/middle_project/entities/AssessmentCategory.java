package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AssessmentCategory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class AssessmentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_cate_id")
    private Integer assessmentCateId;

    @Column(name = "assessment_cate_name", columnDefinition = "longtext")
    private String assessmentCateName;

    @Column(name = "status")
    private Integer status;



//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "assessment_id", referencedColumnName = "assessment_id")
//    private Assessment assessmentId;

    @OneToOne(mappedBy = "assessmentCateId")
    private Assessment assessment;
}
