package doan.middle_project.repositories;


import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.entities.Elective;
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

    @Query(value = "select s.syllabus_id, su.subject_code, su.subject_name, s.syllabus_name, s.is_active, s.is_proved, d.decision_date, d.decision_no\n" +
            "from syllabus s \n" +
            "join subject su on s.subject_id = su.subject_id\n" +
            "join decision d on s.decision_id = d.decision_id\n" +
            "where s.syllabus_id = ?1 and s.is_active = 1 ",nativeQuery = true)
    public List<Object[]> getSyllabusById(Integer id_syllabus);

    @Query(value = "select s.syllabus_id, su.subject_code, su.subject_name, s.syllabus_name, s.is_active, s.is_proved, d.decision_date, d.decision_no\n" +
            "from syllabus s \n" +
            "join subject su on s.subject_id = su.subject_id\n" +
            "join decision d on s.decision_id = d.decision_id where s.is_active = 1 ",nativeQuery = true)
    public List<Object[]> getSyllabus();
}
