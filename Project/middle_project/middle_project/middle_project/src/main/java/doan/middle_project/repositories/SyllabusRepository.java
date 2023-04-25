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
    @Query(value = "select syllabus_id, syllabus_code, syllabus_description, syllabus_name from syllabus s\n" +
            "where syllabus_id = ?1 and is_active = 1 ",nativeQuery = true)
    public List<Object[]> getSyllabusById(Integer id_syllabus);

    @Query(value = "select syllabus_id, syllabus_code, syllabus_description, syllabus_name from syllabus where is_active = 1 ",nativeQuery = true)
    public List<Object[]> getSyllabus();
}