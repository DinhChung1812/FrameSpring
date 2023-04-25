package doan.middle_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Material")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Integer materialId;

    @Column(name = "material_code", columnDefinition = "longtext")
    private String materialCode;

    @Column(name = "material_description", columnDefinition = "longtext")
    private String materialDescription;

    @Column(name = "author", columnDefinition = "longtext")
    private String author;

    @Column(name = "publisher", columnDefinition = "longtext")
    private String publisher;

    @Column(name = "published_date")
    private Integer publishedDate;

    @Column(name = "edition")
    private Integer edition;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "is_main_material")
    private boolean isMainMaterial;

    @Column(name = "is_hard_copy")
    private boolean isHardCopy;

    @Column(name = "is_online")
    private boolean isOnline;

    @Column(name = "note", columnDefinition = "longtext")
    private String note;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    private Subject subject;
}
