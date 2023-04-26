package doan.middle_project.repositories;

import doan.middle_project.entities.AssessmentCategory;
import doan.middle_project.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssessmentCategoryRepository extends JpaRepository<AssessmentCategory, Integer> {
    @Query(value = "SELECT * FROM assessment_category ac\n" +
            "where ac.assessment_cate_id =?1",nativeQuery = true)
    AssessmentCategory getAssById(Integer id);
}
