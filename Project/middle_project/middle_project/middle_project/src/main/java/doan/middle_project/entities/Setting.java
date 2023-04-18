package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "setting")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setting_id")
    private Integer settingId;

    @Column(name = "name", columnDefinition = "longtext")
    private String name;

    @Column(name = "description", columnDefinition = "longtext")
    private String description;

    @Column(name = "display_order", columnDefinition = "longtext")
    private int displayOrder;

    @Column(name = "status")
    private Integer status;

    @Column(name = "type")
    private Integer type;

//    @ManyToOne
//    @JoinColumn(name = "type", referencedColumnName = "role_id", nullable = false)
//    private UserRole userRole;

    @OneToOne(mappedBy = "setting")
    private UserRole userRole;

    @OneToMany(mappedBy = "settingRoleId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Permission> permissionsRole;

    @OneToMany(mappedBy = "settingPageId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Permission> permissionsPage;

}
