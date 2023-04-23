package doan.middle_project.repositories;

import doan.middle_project.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus,Integer> {

    Syllabus findBySyllabusName(String name);

    @Query(value = "select sy.syllabus_id,s.subject_code,s.subject_name, syllabus_name,sy.is_active,sy.is_proved,d.decision_no  from subject s join syllabus sy on s.subject_id = sy.syllabus_id \n" +
            "\t\t\t\t\t\tjoin decision d on d.decision_id = sy.decision_id where s.subject_code like %?1%",nativeQuery = true)
    List<Object[]> getSyllabusBysubjectCode(String text);

    @Query(value = "select sy.syllabus_id,s.subject_code,s.subject_name, syllabus_name,sy.is_active,sy.is_proved,d.decision_no  from subject s join syllabus sy on s.subject_id = sy.syllabus_id \n" +
            "\t\t\t\t\t\tjoin decision d on d.decision_id = sy.decision_id where s.subject_name like %?1%",nativeQuery = true)
    List<Object[]> getSyllabusBysubjectName(String text);

    @Query(value = "select sy.syllabus_id,s.subject_code,s.subject_name, syllabus_name,sy.is_active,sy.is_proved,d.decision_no  from subject s join syllabus sy on s.subject_id = sy.syllabus_id \n" +
            "\t\t\t\t\t\tjoin decision d on d.decision_id = sy.decision_id ",nativeQuery = true)
    List<Object[]> getAllSyllabus();
}
