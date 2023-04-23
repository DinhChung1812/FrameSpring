package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.ElectiveRepository;
import doan.middle_project.repositories.PORepository;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ElectiveServiceImpl implements ElectiveService {

    @Autowired
    ElectiveRepository electiveRepository;

    @Autowired
    CuriculumRepository curiculumRepository;

    @Override
    public ResponseEntity<?> getAllElective(String code) {
        List<ElectiveVo> lstElective = new ArrayList<>();
        if(code == null || code.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
            List<CuriculumVo> lst = curiculumRepository.getCuriculumByCode(code);
            if (lst.size() == 0){
                return new ResponseEntity<>("Không tồn tại curriculum: " + code, HttpStatus.NOT_FOUND);
            }
            lstElective = electiveRepository.getElectiveByCuriculum(code);
        }
        Map<String, List<ElectiveVo>> lstElectiveGrouped =
                lstElective.stream().collect(Collectors.groupingBy(w -> w.getElectiveCode()));
        return ResponseEntity.ok(lstElectiveGrouped);
    }
}
