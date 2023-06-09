package doan.middle_project.repositories;


import doan.middle_project.entities.Questions;
import doan.middle_project.entities.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Sessions, Integer> {

    @Query(value = "select s.sessions_id,s.sessions_code, s.sessions_topic,s.learning_teaching_type,\n" +
            "s.itu,s.student_materials,s.s_download,s.student_tasks,s.url \n" +
            "from sessions s\n" +
            "join syllabus sy on s.syllabus_id = sy.syllabus_id\n" +
            "where sy.syllabus_id = ?1", nativeQuery = true)
    public List<Object[]> getSessionBySyllabus(Integer id_syllabus);

    @Query(value = "select * from sessions s where s.sessions_id = ?1", nativeQuery = true)
    Sessions getSessionDetail(Integer id_session);

    @Query(value = "select * from sessions s where s.sessions_code like %?1%", nativeQuery = true)
    Sessions getSessionDetailByCode(String code);

}