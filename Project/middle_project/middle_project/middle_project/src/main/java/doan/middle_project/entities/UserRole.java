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
}
