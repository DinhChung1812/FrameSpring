package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.*;
import doan.middle_project.dto.Requests.CuriculumEditRequest;

import doan.middle_project.dto.Requests.CurriculumRequest;

import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.entities.*;
import doan.middle_project.exception.BadRequestException;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.*;
import doan.middle_project.service.CuriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CuriculumServiceImpl implements CuriculumService {
    @Autowired
    CuriculumRepository _curiculumRepository;
    @Autowired
    PLORepository _PLORepository;
    @Autowired
    PORepository _PORepository;

    @Autowired
    SubjectRepository _subjectRepository;

    @Autowired
    DecisionRepository decisionRepository;

    @Autowired
    CuriculumRepository curriculumRepository;

    @Autowired
    ElectiveRepository electiveRepository;


    @Override
    public ResponseEntity<?> createCurriculum(Integer curriculumId, CurriculumRequest curriculumRequest) {
        Curriculum curriculum = new Curriculum();

        String mess = "";
        if( curriculumId != null){
            curriculum = _curiculumRepository.findById(curriculumId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy curiculum: "+ curriculumId +"!!!"));
            mess = "Cập nhật curiculum: " + curriculumId;
        } else {
            mess = "Thêm curiculum";
            List<CuriculumVo> lstCuriculum = _curiculumRepository.getCuriculumByCode(curriculumRequest.getCurriculumCode().trim());
            if(lstCuriculum.size()!= 0){
                return new ResponseEntity<>("Bị trùng code", HttpStatus.NOT_FOUND);
            }
        }

        curriculum.setCurriculumCode(curriculumRequest.getCurriculumCode());
        curriculum.setCurriculumName(curriculumRequest.getCurriculumName());
        curriculum.setCurriculumNameEnglish(curriculumRequest.getCurriculumNameEnglish());
        curriculum.setDescription(curriculumRequest.getDescription());
        curriculum.setDescriptionNO(curriculumRequest.getDescriptionNO());
        curriculum.setStatus(1);
        Decision decision = decisionRepository.findById(curriculumRequest.getDecisionId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy decision : "+curriculumRequest.getDecisionId()+"!!!"));
        curriculum.setDecision(decision);
        curriculumRepository.save(curriculum);

        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,"Đã them: "+curriculumRequest.getCurriculumCode()+" thành công"));

    }

    @Override
    public ResponseEntity<?> getAllCuriculum(String code){
        List<CuriculumVo> lstCuriculum = new ArrayList<>();
        List<Object[]> lstObject = new ArrayList<>();
        if(code == null || code.equals("") ){
            lstObject = _curiculumRepository.getAllCuriculum();
        } else {
            lstObject = _curiculumRepository.getCuriculumByCodeCurriculum(code);
        }
        if (lstObject.size() == 0){
            return new ResponseEntity<>("Decision không tồn tại", HttpStatus.NOT_FOUND);
        } else {
            for (Object[] o: lstObject) {
                CuriculumVo curiculum = new CuriculumVo();
                curiculum.setCurriculumId((Integer) o[0]);
                curiculum.setCurriculumCode((String) o[1]);
                curiculum.setCurriculumName((String) o[2]);
                curiculum.setCurriculumNameEnglish((String) o[3]);
                curiculum.setDescription((String) o[4]);
                curiculum.setDescriptionNO((String) o[5]);
                curiculum.setTotalCredit((Integer) o[6]);
                curiculum.setStatus((Integer) o[7]);
                curiculum.setDecision_id((Integer) o[8]);
                curiculum.setDecision_date((Date) o[9]);
                curiculum.setDecision_no((String) o[10]);
                lstCuriculum.add(curiculum);
            }
        }
        if (lstCuriculum.size() == 0){
            return null;
        }
//        else {
//            for (CuriculumVo item : lstCuriculum) {
//                List<PLOVo> lstPLOByCuriculumCode = _PLORepository.getPLOByCuriculumCode(item.getCurriculumCode());
//                item.setLstPLO(lstPLOByCuriculumCode);
//                List<POVo> lstPOByCuriculumCode = _PORepository.getPOByCuriculumCode(item.getCurriculumCode());
//                item.setLstPO(lstPOByCuriculumCode);
//                List<SubjectVo> lstSubjectByCuriculumCode = _subjectRepository.getSubjectByCuriculumCode(item.getCurriculumCode());
//                item.setLstSubject(lstSubjectByCuriculumCode);
//            }
//        }
        return ResponseEntity.ok(lstCuriculum);
    }

    @Override
    public ResponseEntity<?> addOrEditCuriculum(Integer curiculumId, CuriculumEditRequest curiculumEditRequest) throws BadRequestException {
        Curriculum curriculum = new Curriculum();
        String mess = "";
        if( curiculumId != -1){
            curriculum = _curiculumRepository.findById(curiculumId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy curiculum: "+curiculumId+"!!!"));
            mess = "Cập nhật curiculum: " + curiculumId;
        } else {
            mess = "Thêm curiculum";
        }

        curriculum.setCurriculumCode(curiculumEditRequest.getCurriculumCode());
        curriculum.setCurriculumName(curiculumEditRequest.getCurriculumName());
        curriculum.setCurriculumNameEnglish(curiculumEditRequest.getCurriculumNameEnglish());
        curriculum.setDescription(curiculumEditRequest.getDescription());
        curriculum.setDescriptionNO(curiculumEditRequest.getDescriptionNO());
        curriculum.setTotalCredit(curiculumEditRequest.getTotalCredit());
        List<Elective> lstElect = new ArrayList<>();
        Elective elective = electiveRepository.findById(curiculumEditRequest.getElectiveId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy elective: "+curiculumEditRequest.getElectiveId()+"!!!"));
        lstElect.add(elective);
        curriculum.setElectiveId(lstElect);
        Decision decision = decisionRepository.findById(curiculumEditRequest.getDecisionId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy decision: "+curiculumEditRequest.getDecisionId()+"!!!"));
        curriculum.setDecision(decision);
        _curiculumRepository.save(curriculum);

        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
    }

    @Override
    public ResponseEntity<?> updateTotalCreditCuriculum(Integer curiculumId) throws BadRequestException {
        int totalCre =0;
        if( curiculumId != null || !curiculumId.equals("")){
            List<SubjectVo> lstSubject =_subjectRepository.getSubjectByCuriculumID(curiculumId);
            if (lstSubject.size()!=0){
                for (SubjectVo item: lstSubject) {
                    totalCre += item.getCredit();
                }
            }
        }
        Curriculum curriculum = _curiculumRepository.findById(curiculumId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy curiculum: "+curiculumId+"!!!"));
        curriculum.setTotalCredit(totalCre);
        _curiculumRepository.save(curriculum);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,"" +" thành công"));
    }

    @Override
    public ResponseEntity<?> deleteCuriculum(Integer curiculumId) {
        Curriculum curriculum = _curiculumRepository.findById(curiculumId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy curiculum: "+curiculumId+"!!!"));
        curriculum.setStatus(0); // 1 hoat dong, 0 da xoa
        _curiculumRepository.save(curriculum);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,"Đã xóa curiculum: "+curiculumId+" thành công"));
    }

    @Override
    public List<PLOVo> getAllPLO(String code) {
        List<PLOVo> lstPlo = new ArrayList<>();
        if(code == null || code.equals("") ){
            lstPlo = _PLORepository.getPLOByCuriculum();
        } else {
            lstPlo = _PLORepository.getPLOByCuriculumCode(code);
        }
        if (lstPlo.size() == 0){
            return null;
        }
        return lstPlo;
    }

    @Override
    public List<POVo> getAllPO(String code) {
        List<POVo> lstPo = new ArrayList<>();
        if(code == null || code.equals("") ){
            lstPo = _PORepository.getPOByCuriculum();
        } else {
            lstPo = _PORepository.getPOByCuriculumCode(code);
        }
        if (lstPo.size() == 0){
            return null;
        }
        return lstPo;
    }


}
