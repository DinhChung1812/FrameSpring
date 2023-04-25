package doan.middle_project.repositories;


import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.entities.Elective;
import doan.middle_project.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, Integer> {
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