package doan.middle_project.repositories;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.common.vo.SubjectVo;
import doan.middle_project.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    @Query("select new doan.middle_project.common.vo.SubjectVo(" +
            "s.subjectId,s.subjectCode,s.subjectName,s.subjectNote, s.semester, s.credit, s.preRequisite)" +
            "from Subject s where s.status = 1")
    public List<SubjectVo> getAllSubject();

    @Query("select new doan.middle_project.common.vo.SubjectVo(" +
            "s.subjectId,s.subjectCode,s.subjectName,s.subjectNote, s.semester, s.credit, s.preRequisite)" +
            "from Subject s where s.status = 1 and s.subjectCode LIKE :code")
    public List<SubjectVo> getSubjectByCode(String code);

    @Query("select new doan.middle_project.common.vo.SubjectVo(" +
            "s.subjectId,s.subjectCode,s.subjectName,s.subjectNote, s.semester, s.credit, s.preRequisite)" +
            "from Subject s join s.curriculum c " +
            "where s.status = 1 and c.curriculumCode LIKE :code")
    public List<SubjectVo> getSubjectByCuriculumCode(String code);
}
