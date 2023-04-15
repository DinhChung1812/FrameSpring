package doan.middle_project.repositories;

import doan.middle_project.entities.Account;
import doan.middle_project.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

//    @Query("select ur from UserRole ur where ur.accountId =?1")
//    public UserRole findRoleByAccountId(String accountID);
}
