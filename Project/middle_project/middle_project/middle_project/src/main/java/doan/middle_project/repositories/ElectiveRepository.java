package doan.middle_project.repositories;


import doan.middle_project.entities.Elective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectiveRepository extends JpaRepository<Elective, Integer> {

    @Query(value = "select e.elective_id, e.elective_code, e.elective_name, s.subject_name, s.subject_code, s.subject_id \n" +
            "from elective e \n" +
            "join subject s on e.elective_id = s.elective_id\n" +
            "where e.status = 1 and e.elective_id = ?1", nativeQuery = true)
    public List<Object[]> getAllSubjectByElectiveId(Integer electiveId);

    @Query(value = "select e.elective_id, e.elective_code, e.elective_name from elective e \n" +
            "join curriculum_elective ce on e.elective_id = ce.elective_id\n" +
            "join curriculum c on ce.curriculum_id = c.curriculum_id\n" +
            "where e.status = 1 and c.curriculum_code like %?1%", nativeQuery = true)
    public List<Object[]> getElectiveByCurriCode(String electiveId);

    @Query(value = "select e.elective_id, e.elective_code, e.elective_name from elective e where e.status = 1", nativeQuery = true)
    public List<Object[]> getAllElective();

    @Query(value = "SELECT e.elective_id, e.elective_code, e.elective_name FROM elective e where e.elective_code like %?1% and e.status = 1", nativeQuery = true)
    public List<Object[]> getElectiveByCode(String codeElective);

    @Query(value = "SELECT e.* FROM elective e\n" +
            "join curriculum_elective ce on e.elective_id = ce.elective_id\n" +
            "where ce.curriculum_id = ?1", nativeQuery = true)
    public List<Elective> getElectiveByCurriID(Integer curriId);


}