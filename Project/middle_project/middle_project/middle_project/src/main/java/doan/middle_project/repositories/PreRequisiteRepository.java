package doan.middle_project.repositories;

import doan.middle_project.entities.PreRequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreRequisiteRepository extends JpaRepository<PreRequisite,Integer> {

    @Query(value = "select sl.syllabus_id, s.subject_code,sl.syllabus_name, d.decision_no from subject s join syllabus sl on s.subject_id = sl.subject_id\n" +
            "join decision d on sl.decision_id = d.decision_id where s.subject_code = ?1",nativeQuery = true)
    List<Object[]> getPreRequisite(String subjectCode);

    @Query(value = "select pr.requisite_subject_code from pre_requisite pr where pr.subject_code = ?1",nativeQuery = true)
    List<Object[]> getPreRequisiteOf(String subjectCode);

    @Query(value = "select p.requisite_subject_code from pre_requisite p join subject s on p.subject_code = s.subject_code where s.subject_id=?1",nativeQuery = true)
    List<Object[]> getPreRequisiteBySubject_code(Integer subjectId);

}
