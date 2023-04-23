package doan.middle_project.repositories;

import doan.middle_project.entities.Decision;
import doan.middle_project.entities.PLO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Integer> {
    @Query(value = "select d.decision_id, d.decision_date,d.decision_no, d.create_date,d.filename,d.note from decision d ", nativeQuery = true)
    public List<Object[]> getAllDecision();

    @Query(value = "select d.decision_id, d.decision_date,d.decision_no, d.create_date,d.filename,d.note from decision d\n" +
            "join curriculum c on d.decision_id = c.decision_id\n" +
            "where c.curriculum_code = %?1%", nativeQuery = true)
    public List<Object[]> getAllDecisionByCodeCurriculum(String code);

    @Query(value = "select d.decision_id, d.decision_date,d.decision_no, d.create_date,d.filename,d.note from decision d\n" +
            "join syllabus s on d.decision_id = s.decision_id\n" +
            "where s.syllabus_code = %?1%", nativeQuery = true)
    public List<Object[]> getAllDecisionByCodeSyllybus(String code);
}
