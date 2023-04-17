package doan.middle_project.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "access_all")
    private Integer accessAll;

    @Column(name = "can_read")
    private Integer canRead;

    @Column(name = "can_add")
    private Integer canAdd;

    @Column(name = "can_edit")
    private Integer canEdit;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "setting_id", nullable = false)
    private Setting settingRoleId;

    @ManyToOne
    @JoinColumn(name = "page_id", referencedColumnName = "setting_id", nullable = false)
    private Setting settingPageId;

}
