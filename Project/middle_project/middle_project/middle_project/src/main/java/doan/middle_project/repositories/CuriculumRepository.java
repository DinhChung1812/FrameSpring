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
    @Query("select new doan.middle_project.common.vo.CuriculumVo(" +
            "c.curriculumId,c.curriculumCode,c.curriculumName,c.curriculumNameEnglish, c.description, c.descriptionNO, c.totalCredit)" +
            "from Curriculum c where c.status = 1")
    public List<CuriculumVo> getAllCuriculum();
}
