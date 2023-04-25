package doan.middle_project.repositories;


import doan.middle_project.common.vo.AccountManageVo;
import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.common.vo.FriendsVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.entities.Account;
import doan.middle_project.entities.Elective;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectiveRepository extends JpaRepository<Elective, Integer> {

    @Query(value = "select e.elective_id, e.elective_code, e.elective_name, s.subject_name, s.subject_code, s.subject_id \n" +
            "from elective e \n" +
            "join curriculum_elective ce on e.elective_id = ce.elective_id\n" +
            "join curriculum c on ce.curriculum_id = c.curriculum_id\n" +
            "join subject s on e.subject_id = s.subject_id\n" +
            "where c.curriculum_code like %?1%", nativeQuery = true)
    public List<Object[]> getElectiveByCuriculum(String code);

    @Query(value = "SELECT e.elective_id, e.elective_code, e.elective_name FROM elective e where e.elective_id = ?1 and e.status = 1", nativeQuery = true)
    public List<Object[]> getElectiveById(Integer electiveId);

    @Query(value = "SELECT e.elective_id, e.elective_code, e.elective_name FROM elective e where e.elective_code like %?1% and e.status = 1", nativeQuery = true)
    public List<Object[]> getElectiveByCode(String codeElective);

}