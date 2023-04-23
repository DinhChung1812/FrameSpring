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

    @Query("select new doan.middle_project.common.vo.ElectiveVo(" +
            "e.electiveId, e.electiveCode, e.electiveName, s.subjectName, s.subjectCode, s.subjectId)" +
            "from Elective e join e.curriculum c join e.subject s " +
            "where e.status = 1 and c.curriculumCode LIKE :code")
    public List<ElectiveVo> getElectiveByCuriculum(String code);

    @Query(value = "SELECT e.elective_id, e.elective_code, e.elective_name FROM elective e where e.elective_id = 1 and e.status = 1", nativeQuery = true)
    public List<Object[]> getElectiveById(Integer electiveId);

}