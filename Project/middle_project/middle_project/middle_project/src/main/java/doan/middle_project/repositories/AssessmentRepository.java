package doan.middle_project.repositories;

import doan.middle_project.common.vo.AssessmentVo;
import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.entities.Assessment;
import doan.middle_project.entities.Elective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
    @Query(value = "select a.assessment_id,ac.assessment_cate_name , a.type, a.part, a.weight, a.completion_criteria, a.duration, a.question_type, a.question_no, a.knowledge_skill, a.grading_guide, a.note\n" +
            "from assessment a \n" +
            "join assessment_category ac on a.assessment_cate_id = ac.assessment_cate_id\n" +
            "join syllabus_assessment sa on a.assessment_id = sa.assessment_id\n" +
            "join syllabus s on sa.syllabus_id = s.syllabus_id " +
            "where s.syllabus_code like %?1%",nativeQuery = true)
    public List<Object[]> getAssessmentBySubject(String code);

    @Query(value = "select assessment_cate_id, assessment_cate_name from assessment_category where assessment_cate_id = ?1",nativeQuery = true)
    public List<Object[]> getAssessmenCatetById(Integer idAssCate);
    @Query(value = "select assessment_cate_id, assessment_cate_name from assessment_category",nativeQuery = true)
    public List<Object[]> getAssessmenCate();

}
