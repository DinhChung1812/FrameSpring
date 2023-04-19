package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.common.vo.POVo;
import doan.middle_project.common.vo.SubjectVo;
import doan.middle_project.dto.Requests.CuriculumEditRequest;

import doan.middle_project.dto.Requests.CurriculumRequest;

import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.entities.Account;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.Decision;
import doan.middle_project.entities.PO;
import doan.middle_project.exception.BadRequestException;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.*;
import doan.middle_project.service.CuriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    CurriculumRepository curriculumRepository;

    @Override
    public void createCurriculum(Integer decisionId, CurriculumRequest curriculumRequest) {
        Curriculum c = new Curriculum();
        c.setCurriculumCode(curriculumRequest.getCurriculumCode());
        c.setCurriculumName(curriculumRequest.getCurriculumName());
        c.setCurriculumNameEnglish(curriculumRequest.getCurriculumNameEnglish());
        c.setDescription(curriculumRequest.getDescription());
        c.setDescriptionNO(curriculumRequest.getDescriptionNO());
        c.setStatus(1);
        Decision decision = decisionRepository.findById(1).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy curiculum: "+decisionId+"!!!"));
        c.setDecision(decision);
        curriculumRepository.save(c);
    }

    @Override
    public List<CuriculumVo> getAllCuriculum(String code){
        List<CuriculumVo> lstCuriculum = new ArrayList<>();
        if(code == null || code.equals("") ){
            lstCuriculum = _curiculumRepository.getAllCuriculum();
        } else {
            lstCuriculum = _curiculumRepository.getCuriculumByCode(code);
        }
        if (lstCuriculum.size() == 0){
            return null;
        } else {
            for (CuriculumVo item : lstCuriculum) {
                List<PLOVo> lstPLOByCuriculumCode = _PLORepository.getPLOByCuriculumCode(item.getCurriculumCode());
                item.setLstPLO(lstPLOByCuriculumCode);
                List<POVo> lstPOByCuriculumCode = _PORepository.getPOByCuriculumCode(item.getCurriculumCode());
                item.setLstPO(lstPOByCuriculumCode);
                List<SubjectVo> lstSubjectByCuriculumCode = _subjectRepository.getSubjectByCuriculumCode(item.getCurriculumCode());
                item.setLstSubject(lstSubjectByCuriculumCode);
            }
        }
        return lstCuriculum;
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
        _curiculumRepository.save(curriculum);

        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
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
        List<PLOVo> lstPLOByCuriculumCode = _PLORepository.getPLOByCuriculumCode(code);
        if (lstPLOByCuriculumCode.size() == 0){
            return null;
        }
        return lstPLOByCuriculumCode;
    }

    @Override
    public List<POVo> getAllPO(String code) {
        List<POVo> lstPOByCuriculumCode = _PORepository.getPOByCuriculumCode(code);
        if (lstPOByCuriculumCode.size() == 0){
            return null;
        }
        return lstPOByCuriculumCode;
    }


}
