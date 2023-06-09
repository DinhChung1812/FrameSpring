package doan.middle_project.repositories;


import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.entities.Elective;
import doan.middle_project.entities.Questions;
import doan.middle_project.entities.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {

    @Query(value = "select q.questions_id, q.questions_name, q.questions_detail from questions q\n" +
            "join sessions s on q.sessions_id = s.sessions_id\n" +
            "where s.sessions_id = ?1", nativeQuery = true)
    public List<Object[]> getAllQuestionBySession(Integer sessionId);

    @Query(value = "select * from questions q where q.questions_id = ?1", nativeQuery = true)
    Questions getQuestionDetail(Integer questions_id);

}