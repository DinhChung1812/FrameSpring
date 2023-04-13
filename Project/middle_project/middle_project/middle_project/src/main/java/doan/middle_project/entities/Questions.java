package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questions_id")
    private Integer questionsId;

    @Column(name = "questions_name", columnDefinition = "longtext")
    private String questionsName;

    @Column(name = "questions_detail", columnDefinition = "longtext")
    private String questionsDetail;

    @ManyToOne
    @JoinColumn(name = "sessions_id", referencedColumnName = "sessions_id", nullable = false)
    private Sessions sessions;
}
