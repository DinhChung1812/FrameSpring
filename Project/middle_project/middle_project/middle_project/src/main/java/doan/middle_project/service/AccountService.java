package doan.middle_project.service;

import doan.middle_project.common.vo.AccountManageVo;
import doan.middle_project.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import javax.security.auth.login.AccountNotFoundException;

public interface AccountService {

     void changePassword (String userName,  String newPass) throws AccountNotFoundException;

     Page<AccountManageVo> findAll(String searchData, Integer pageIndex, Integer pageSize);

     ResponseEntity<?> changeRole(Integer accountId, String role) ;

     ResponseEntity<?> deleteAccount(Integer accountId) ;
}
