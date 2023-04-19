package doan.middle_project.repositories;

import doan.middle_project.entities.Decision;
import doan.middle_project.entities.PLO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Integer> {
}
