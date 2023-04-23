package doan.middle_project.repositories;

import doan.middle_project.entities.AssessmentCategory;
import doan.middle_project.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentCategoryRepository extends JpaRepository<AssessmentCategory, Integer> {
}
