package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Sessions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Sessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sessions_id")
    private Integer sessionsId;

    @Column(name = "sessions_code", columnDefinition = "longtext")
    private String sessionsCode;

    @Column(name = "sessions_topic", columnDefinition = "longtext")
    private String sessionsTopic;

    @Column(name = "learning_teaching_type")
    private Integer learningTeachingType;

    @Column(name = "itu", columnDefinition = "longtext")
    private String itu;

    @Column(name = "student_materials", columnDefinition = "longtext")
    private String studentMaterials;

    @Column(name = "s_download", columnDefinition = "longtext")
    private String sDownload;

    @Column(name = "student_tasks", columnDefinition = "longtext")
    private String studentTasks;

    @Column(name = "url", columnDefinition = "longtext")
    private String url;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany( mappedBy = "sessions",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Questions> questions;
}
