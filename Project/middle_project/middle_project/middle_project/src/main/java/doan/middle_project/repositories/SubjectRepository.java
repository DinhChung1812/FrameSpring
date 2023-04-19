package doan.middle_project.repositories;

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

    @Query(value = "select * from subject where curriculum_id =?1", nativeQuery = true)
    List<Subject> findSubjectByCurriculum(Integer curriculumId);

    @Query(value = "select p.plo_id,p.plo_name from plo p join subject_plo sp on sp.plo_id = p.plo_id where sp.subject_id=?1",nativeQuery = true)
    List<Object[]> getListPlo(Integer subjectId);
}
