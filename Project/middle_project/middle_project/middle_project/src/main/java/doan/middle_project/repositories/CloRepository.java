package doan.middle_project.repositories;

import doan.middle_project.entities.CLO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloRepository extends JpaRepository<CLO,Integer> {
    @Query(value = "select c.clo_id,c.clo_name,p.plo_id,p.plo_name from plo p join clo_plo cp on p.plo_id = cp.plo_id\n" +
            "\t\t\t\t\tjoin clo c on cp.clo_id = c.clo_id\n" +
            "                    join subject s on s.subject_id = c.subject_id\n" +
            "                    where subject_code= ?1",nativeQuery = true)
    List<Object[]> getCloPloMapping(String subjectCode);
}
