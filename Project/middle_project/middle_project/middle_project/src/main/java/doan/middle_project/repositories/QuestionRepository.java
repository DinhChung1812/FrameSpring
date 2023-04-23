package doan.middle_project.repositories;


import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.entities.Elective;
import doan.middle_project.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {

    @Query(value = "select q.questions_id, q.questions_name, q.questions_detail from questions q\n" +
            "join sessions s on q.sessions_id = s.sessions_id\n" +
            "join syllabus sy on s.syllabus_id = sy.syllabus_id\n" +
            "where sy.syllabus_code like %?1%", nativeQuery = true)
    public List<Object[]> getQuestionBySyllabus(String code);

}