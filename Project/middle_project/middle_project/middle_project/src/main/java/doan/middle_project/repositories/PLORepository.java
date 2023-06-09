package doan.middle_project.repositories;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.PLO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PLORepository extends JpaRepository<PLO, Integer> {
    @Query("select new doan.middle_project.common.vo.PLOVo(" +
            "plo.ploId,plo.ploName,plo.ploDescription)" +
            "from PLO plo join plo.curriculum c " +
            "where plo.status = 1")
    public List<PLOVo> getPLOByCuriculum();

    @Query("select new doan.middle_project.common.vo.PLOVo(" +
            "plo.ploId,plo.ploName,plo.ploDescription)" +
            "from PLO plo join plo.curriculum c " +
            "where plo.status = 1 and c.curriculumCode LIKE :code")
    public List<PLOVo> getPLOByCuriculumCode(String code);

    @Query(value = "select p.* from plo p join curriculum c on p.curriculum_id = c.curriculum_id where c.curriculum_code = ?1 and p.status=?2",nativeQuery = true)
    List<PLO> findByCurriculumCode(String curriculumCode,Integer status);

}
