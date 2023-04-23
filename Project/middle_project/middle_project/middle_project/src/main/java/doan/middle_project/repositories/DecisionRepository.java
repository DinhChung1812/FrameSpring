package doan.middle_project.repositories;

import doan.middle_project.entities.Decision;
import doan.middle_project.entities.PLO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Integer> {
    @Query(value = "select d.* from curriculum_subject cs join curriculum c on cs.curriculum_id = c.curriculum_id\n" +
            "\t\t\t\t\t\t\t\t\tjoin decision d on d.decision_id = c.decision_id where cs.subject_id = ?1",nativeQuery = true)
    Decision getBySubjectId(Integer subjectId);
}
