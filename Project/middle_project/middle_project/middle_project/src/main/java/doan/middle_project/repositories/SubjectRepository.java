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

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

//    @Query(value = "select s.subject_id,s.subject_code,p.plo_id,p.plo_name from  subject s join subject_plo sp on s.subject_id = sp.subject_id \n" +
//            "                         join plo p on sp.plo_id = p.plo_id where p.curriculum_id=?1",nativeQuery = true)
//    List<Object[]> findByCurriculum(Integer curriculum);

    @Query(value = "select s.* from subject s join curriculum_subject cs on s.subject_id = cs.subject_id where curriculum_id = ?1", nativeQuery = true)
    List<Subject> findSubjectByCurriculum(Integer curriculumId);

    @Query(value = "select p.plo_id,p.plo_name from plo p join subject_plo sp on sp.plo_id = p.plo_id where sp.subject_id=?1",nativeQuery = true)
    List<Object[]> getListPlo(Integer subjectId);

    @Query(value = "select s.* from subject s where s.subject_code = ?1 ",nativeQuery = true)
    Subject findBySubject_code(String code);

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
            "from Subject s join s.curriculumId c " +
            "where s.status = 1 and c.curriculumCode LIKE :code")
    public List<SubjectVo> getSubjectByCuriculumCode(String code);

    @Query(value = "select * from subject s where s.subject_id = ?1",nativeQuery = true)
    Subject getSubjectCodeAndNoCreadit(Integer subjectId);
    
    @Query("select new doan.middle_project.common.vo.SubjectVo(" +
            "s.subjectId,s.subjectCode,s.subjectName,s.subjectNote, s.semester, s.credit, s.preRequisite)" +
            "from Subject s join s.curriculumId c " +
            "where s.status = 1 and c.curriculumId = ?1")
    public List<SubjectVo> getSubjectByCuriculumID(Integer code);

    @Query(value = "SELECT * FROM subject s where s.elective_id IS NULL and s.status = 1", nativeQuery = true)
    public List<Object[]> getAllSubjectNotElective();

    @Query(value = "select s.* from subject s where s.subject_id = ?1 and s.status = 1", nativeQuery = true)
    Subject findSubjectById(Integer curriculumId);

}
