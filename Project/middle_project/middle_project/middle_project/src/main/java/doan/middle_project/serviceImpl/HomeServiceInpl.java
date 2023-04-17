package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Requests.ProfileEditRequest;
import doan.middle_project.dto.Requests.ProfileRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.entities.Account;
import doan.middle_project.exception.BadRequestException;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.AccountRepository;
import doan.middle_project.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HomeServiceInpl implements HomeService {


}
