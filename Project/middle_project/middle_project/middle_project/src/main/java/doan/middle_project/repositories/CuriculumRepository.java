package doan.middle_project.repositories;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.entities.Account;
import doan.middle_project.entities.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuriculumRepository extends JpaRepository<Curriculum, Integer> {

    @Query(value = "select * from curriculum  where curriculum_code=?1",nativeQuery = true)
    Curriculum findByCurriculumCode(String code);

//    @Query("select new doan.middle_project.common.vo.CuriculumVo(" +
//            "c.curriculumId,c.curriculumCode,c.curriculumName,c.curriculumNameEnglish, c.description, c.descriptionNO, c.totalCredit, c.status)" +
//            "from Curriculum c where c.status = 1")
//    public List<CuriculumVo> getAllCuriculum();

    @Query("select new doan.middle_project.common.vo.CuriculumVo(" +
            "c.curriculumId,c.curriculumCode,c.curriculumName,c.curriculumNameEnglish, c.description, c.descriptionNO, c.totalCredit, c.status)" +
            "from Curriculum c where c.status = 1 and c.curriculumCode LIKE %?1%")
    public List<CuriculumVo> getCuriculumByCode(String code);

    @Query(value = "select c.curriculum_id,c.curriculum_code,c.curriculum_name,c.curriculum_name_english, \n" +
            "c.description, c.description_no, c.total_credit, c.status,d.decision_id, d.decision_date, d.decision_no \n" +
            "from curriculum c \n" +
            "join decision d on c.decision_id = d.decision_id\n" +
            "where c.status = 1", nativeQuery = true)
    public List<Object[]> getAllCuriculum();

    @Query(value = "select c.curriculum_id,c.curriculum_code,c.curriculum_name,c.curriculum_name_english, \n" +
            "c.description, c.description_no, c.total_credit, c.status,d.decision_id, d.decision_date, d.decision_no \n" +
            "from curriculum c \n" +
            "join decision d on c.decision_id = d.decision_id\n" +
            "where c.status = 1 and c.curriculum_code like %?1%", nativeQuery = true)
    public List<Object[]> getCuriculumByCodeCurriculum(String code);
}
