package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "UserRole")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role", columnDefinition = "longtext")
    private String role;

    @Column(name = "is_active")
    private Integer isActive;

    @ManyToMany (mappedBy = "roleId",cascade = {CascadeType.MERGE})
    private Set<Account> accountId;

//    @OneToMany( mappedBy = "userRole",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Setting> settings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "setting_id", referencedColumnName = "setting_id")
    private Setting setting;
}
