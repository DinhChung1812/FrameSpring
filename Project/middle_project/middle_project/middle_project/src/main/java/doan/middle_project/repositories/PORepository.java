package doan.middle_project.repositories;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.common.vo.POVo;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.PO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PORepository extends JpaRepository<PO, Integer> {
    @Query("select new doan.middle_project.common.vo.POVo(" +
            "po.poId,po.poName,po.poDescription)" +
            "from PO po join po.curriculum c " +
            "where po.status = 1")
    public List<POVo> getPOByCuriculum();

    @Query("select new doan.middle_project.common.vo.POVo(" +
            "po.poId,po.poName,po.poDescription)" +
            "from PO po join po.curriculum c " +
            "where po.status = 1 and c.curriculumCode LIKE :code")
    public List<POVo> getPOByCuriculumCode(String code);


    @Query(value = "select p.* from po p join curriculum c on p.curriculum_id = c.curriculum_id where c.curriculum_code = ?1 and p.status=?2", nativeQuery = true)
    List<PO> getPOByCurriculumCode(String curriculumCode,Integer status);
}
