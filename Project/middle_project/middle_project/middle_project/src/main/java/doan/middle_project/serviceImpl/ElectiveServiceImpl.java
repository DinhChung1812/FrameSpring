package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.dto.Requests.ElectiveRequest;
import doan.middle_project.dto.Responds.ElectiveResponse;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.dto.Responds.SubjectResponse;
import doan.middle_project.entities.*;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.ElectiveRepository;
import doan.middle_project.repositories.SubjectRepository;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ElectiveServiceImpl implements ElectiveService {

    @Autowired
    ElectiveRepository electiveRepository;

    @Autowired
    CuriculumRepository curiculumRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public ResponseEntity<?> getAllSubjectByElectiveId(Integer electiveId) {
        List<Object[]> lstObject = new ArrayList<>();
        List<ElectiveVo> lstElective = new ArrayList<>();
        List<ElectiveResponse> lstElectiveResponse = new ArrayList<>();

        if(electiveId == null || electiveId.equals("") ){
            return new ResponseEntity<>("ElectiveId null", HttpStatus.NOT_FOUND);
        } else {
            Elective elective = electiveRepository.findById(electiveId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy elective: "+electiveId+"!!!"));
            lstObject = electiveRepository.getAllSubjectByElectiveId(electiveId);
            for (Object[] o: lstObject) {
                ElectiveVo electiveVo = new ElectiveVo();
                electiveVo.setElectiveId((Integer) o[0]);
                electiveVo.setElectiveCode((String) o[1]);
                electiveVo.setElectiveName((String) o[2]);
                electiveVo.setSubjectName((String) o[3]);
                electiveVo.setSubjectCode((String) o[4]);
                electiveVo.setSubjectId((Integer) o[5]);
                lstElective.add(electiveVo);
            }
        }
        Map<String, List<ElectiveVo>> lstElectiveGrouped =
                lstElective.stream().collect(Collectors.groupingBy(w -> w.getElectiveCode()));

        lstElectiveGrouped.forEach((key, value) -> {
            Boolean check = true;
            ElectiveResponse elect = new ElectiveResponse();
            elect.setEletiveCode(key);
            List<SubjectResponse> lstSubjectResponse = new ArrayList<>();
            for (ElectiveVo item: value) {
                SubjectResponse subj = new SubjectResponse();
                if (check == true){
                    elect.setEletiveId(item.getElectiveId());
                    elect.setEletiveName(item.getElectiveName());
                    check = false;
                }
                subj.setSubjectId(item.getSubjectId());
                subj.setSubjectCode(item.getSubjectCode());
                subj.setSubjectName(item.getSubjectName());
                lstSubjectResponse.add(subj);
            }
            elect.setListSubject(lstSubjectResponse);
            lstElectiveResponse.add(elect);

        });
        return ResponseEntity.ok(lstElectiveResponse);
    }

    @Override
    public ResponseEntity<?> getElectiveByCurriCode(String curriCode) {
        List<ElectiveVo> lstElective = new ArrayList<>();
        List<Object[]> lstObject = new ArrayList<>();
        if(curriCode != null || !curriCode.equals("")){
            lstObject = electiveRepository.getElectiveByCurriCode(curriCode);
        } else{
            lstObject = electiveRepository.getAllElective();
        }
        if (lstObject.size() == 0){
            return new ResponseEntity<>("Elective không tồn tại", HttpStatus.NOT_FOUND);
        } else {
            for (Object[] o: lstObject) {
                ElectiveVo electiveVo = new ElectiveVo();
                electiveVo.setElectiveId((Integer) o[0]);
                electiveVo.setElectiveCode((String) o[1]);
                electiveVo.setElectiveName((String) o[2]);
                lstElective.add(electiveVo);
            }
        }
        return ResponseEntity.ok(lstElective);
    }

    @Override
    public ResponseEntity<?> updateInsertElective(Integer electiveId, ElectiveRequest electiveRequest) {
        Elective elective = new Elective();
        Curriculum curriculum = new Curriculum();
        Subject subject = new Subject();
        String mess = "";
        if( electiveId > 0){
            elective = electiveRepository.findById(electiveId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy assessment: "+electiveId+"!!!"));
            mess = "Cập nhật elective: " + electiveId;
        } else {
            mess = "Thêm elective";
        }

        if( electiveRequest.getCurriculumId() != null || !electiveRequest.getCurriculumId().equals("")){
            curriculum = curiculumRepository.findById(electiveRequest.getCurriculumId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy curriculum: "+electiveRequest.getCurriculumId()+"!!!"));
        }

//        if( electiveRequest.getSubjectId() != null || !electiveRequest.getSubjectId().equals("")){
//            subject = subjectRepository.findById(electiveRequest.getSubjectId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy subject: "+electiveRequest.getSubjectId() +"!!!"));
//        }

        if(electiveId < 0){
            List<Object[]> object = new ArrayList<>();
            object = electiveRepository.getElectiveByCode(electiveRequest.getElectiveCode());
            if (object.size() != 0){
                return new ResponseEntity<>("Elective code bị trùng", HttpStatus.NOT_FOUND);
            }
        }
        elective.setElectiveCode(electiveRequest.getElectiveCode());
        elective.setElectiveName(electiveRequest.getElectiveName());
        elective.setStatus(1);
        Set<Curriculum> setCurriculum = new HashSet<Curriculum>();
        setCurriculum.add(curriculum);
        elective.setCurriculumId(setCurriculum);
//        Set<Subject> setSubject = new HashSet<Subject>();
//        setSubject.add(subject);
//        elective.setSubject(setSubject);
        electiveRepository.save(elective);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
    }
}
