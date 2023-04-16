package doan.middle_project.repositories;

import doan.middle_project.entities.Setting;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingRepository extends JpaRepository<Setting,Integer> {

    @Query(value = "select * from setting  where  type = ?1 and status = ?2", nativeQuery = true)
    List<Setting> findSettingByStatusAndUserRole(Integer type, Integer status, Pageable pageable);

}
