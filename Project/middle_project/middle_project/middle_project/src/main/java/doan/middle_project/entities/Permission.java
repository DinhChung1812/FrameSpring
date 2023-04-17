package doan.middle_project.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Permission")
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "access_all")
    private Boolean accessAll;

    @Column(name = "can_read")
    private Boolean canRead;

    @Column(name = "can_add")
    private Boolean canAdd;

    @Column(name = "can_edit")
    private Boolean canEdit;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "setting_id", nullable = false)
    private Setting settingRoleId;

    @ManyToOne
    @JoinColumn(name = "page_id", referencedColumnName = "setting_id", nullable = false)
    private Setting settingPageId;

}
