package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.DecisionVo;
import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.common.vo.SessionVo;
import doan.middle_project.dto.Requests.DecisionRequest;
import doan.middle_project.dto.Responds.ElectiveResponse;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.dto.Responds.SubjectResponse;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.Decision;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.DecisionRepository;
import doan.middle_project.repositories.ElectiveRepository;
import doan.middle_project.service.DecisionService;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DecisionServiceImpl implements DecisionService {

    @Autowired
    DecisionRepository decisionRepository;

    @Override
    public ResponseEntity<?> getAllDecision(String code_curriculum, String code_syllybus) {
        List<DecisionVo> lstDecision = new ArrayList<>();
        List<Object[]> lstObject = new ArrayList<>();
        if((code_curriculum == null || code_curriculum.equals("")) && (code_syllybus == null || code_syllybus.equals("")) ){
            lstObject = decisionRepository.getAllDecision();
        } else if(code_syllybus == null || code_syllybus.equals("")) {
            lstObject = decisionRepository.getAllDecisionByCodeCurriculum(code_curriculum.trim());
        } else if(code_curriculum == null || code_curriculum.equals("")){
            lstObject = decisionRepository.getAllDecisionByCodeSyllybus(code_syllybus.trim());
        }
        if (lstObject.size() == 0){
            return new ResponseEntity<>("Decision không tồn tại", HttpStatus.NOT_FOUND);
        } else {
            for (Object[] o: lstObject) {
                DecisionVo decision = new DecisionVo();
                decision.setDecisionId((Integer) o[0]);
                decision.setDecisionDate((Date) o[1]);
                decision.setDecisionNo((String) o[2]);
                decision.setCreateDate((Date) o[3]);
                decision.setFileName((String) o[4]);
                decision.setNote((String) o[5]);
                decision.setDecisionName((String) o[6]);
                lstDecision.add(decision);
            }
        }

//        Map<String, List<AssessmentVo>> lstElectiveGrouped =
//                lstElective.stream().collect(Collectors.groupingBy(w -> w.()));
        return ResponseEntity.ok(lstDecision);
    }

    @Override
    public ResponseEntity<?> getDecisionById(Integer decisionId) {
        List<DecisionVo> lstDecision = new ArrayList<>();
        List<Object[]> lstObject = new ArrayList<>();
        if(decisionId != null || !decisionId.equals("")){
            lstObject = decisionRepository.getDecisionById(decisionId);
        }
        if (lstObject.size() == 0){
            return new ResponseEntity<>("Decision không tồn tại", HttpStatus.NOT_FOUND);
        } else {
            for (Object[] o: lstObject) {
                DecisionVo decision = new DecisionVo();
                decision.setDecisionId((Integer) o[0]);
                decision.setDecisionDate((Date) o[1]);
                decision.setDecisionNo((String) o[2]);
                decision.setCreateDate((Date) o[3]);
                decision.setFileName((String) o[4]);
                decision.setNote((String) o[5]);
                decision.setDecisionName((String) o[6]);
                lstDecision.add(decision);
            }
        }
        return ResponseEntity.ok(lstDecision);
    }

    @Override
    public ResponseEntity<?> updateOrInsertDecision(Integer decisionId, DecisionRequest decisionRequest) throws ParseException {
        Decision decision = new Decision();
        String mess = "";
        if( decisionId > 0){
            decision = decisionRepository.findById(decisionId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy decision: "+decisionId+"!!!"));
            mess = "Cập nhật decision: " + decisionId;
        } else {
            mess = "Thêm decision";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date decisionDate = formatter.parse(decisionRequest.getDecisionDate());
        Date createDate = new Date();
        decision.setDecisionNo(decisionRequest.getDecisionNo());
        decision.setDecisionDate(decisionDate);
        decision.setNote(decisionRequest.getNote());
        decision.setCreateDate(createDate);
        decision.setFileName(decisionRequest.getFileName());
        decision.setDecisionName(decisionRequest.getDecisionName());
        decisionRepository.save(decision);

        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
    }
}
