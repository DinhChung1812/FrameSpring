package doan.middle_project.repositories;

import doan.middle_project.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {

    @Query(value = "select * from permission where role_id=?1 and page_id=?2",nativeQuery = true)
    Permission findPermissionByRoleIdAndPageId(Integer roleId,Integer pageId);
}
