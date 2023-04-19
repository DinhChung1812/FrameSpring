package doan.middle_project.repositories;

import doan.middle_project.entities.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {

    @Query(value = "select * from curriculum  where curriculum_code=?1",nativeQuery = true)
    Curriculum findByCurriculumCode(String code);

}
