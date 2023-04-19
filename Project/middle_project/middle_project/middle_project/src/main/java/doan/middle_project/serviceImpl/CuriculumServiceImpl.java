package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.dto.Requests.CuriculumEditRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.entities.Account;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.exception.BadRequestException;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.SettingRepository;
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
}
