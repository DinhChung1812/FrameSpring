package doan.middle_project.serviceImpl;


import doan.middle_project.common.vo.DecisionVo;
import doan.middle_project.dto.Requests.SubjectRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.dto.Responds.PloDto;
import doan.middle_project.dto.Responds.SubjectPloResponse;
import doan.middle_project.dto.Responds.SubjectPloMappingResponse;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.Elective;
import doan.middle_project.entities.Subject;
import doan.middle_project.common.vo.SubjectVo;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.ElectiveRepository;
import doan.middle_project.repositories.SubjectRepository;
import doan.middle_project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    CuriculumRepository curriculumRepository;

    @Autowired
    ElectiveRepository electiveRepository;

    @Override
    public ResponseEntity<?> createSubject(Integer subjectId, SubjectRequest subjectRequest) {
        Subject subject = new Subject();
        String mess = "";
        if( subjectId > 0){
            subject = subjectRepository.findSubjectById(subjectId);
            if (subject == null){
                return new ResponseEntity<>("Subject không tồn tại", HttpStatus.NOT_FOUND);
            }
            mess = "Cập nhật subject: " + subjectId;
        } else {
            mess = "Thêm subject";
        }
        if (subjectId < 0){
            Subject s = subjectRepository.findBySubject_code(subjectRequest.getSubjectCode());
            if (s != null){
                return new ResponseEntity<>("Subject code đã tồn tại", HttpStatus.NOT_FOUND);
            }
        }

        if(subjectRequest.getElectiveId() == null){
            subject.setSubjectCode(subjectRequest.getSubjectCode());
            subject.setSubjectName(subjectRequest.getSubjectName());
            subject.setSubjectNote(subjectRequest.getSubjectNote());
            subject.setSemester(subjectRequest.getSemester());
            subject.setCredit(subjectRequest.getCredit());
            subject.setStatus(1);
        } else {
            if (subjectId > 0){
                Elective elective = electiveRepository.findById(subjectRequest.getElectiveId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy elective: "+subjectRequest.getElectiveId()+"!!!"));
                subject.setElective(elective);
            }
        }

        subjectRepository.save(subject);

        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
    }

    @Override
    public List<SubjectPloResponse> getSubjectPlo(Integer curriculumId) {
        return null;
    }

//    @Override
//    public List<SubjectPloResponse> getSubjectPlo() {
//        List<Object[]> subjectPlo = subjectRepository.findByCurriculum(3);
//        List<SubjectPloResponse> subjectPloResponses = new ArrayList<>();
//
//        for (Object[] o: subjectPlo) {
//            SubjectPloResponse spr = new SubjectPloResponse();
//            spr.setSubjectId((Integer) o[0]);
//            spr.setPloId((Integer) o[2]);
//            spr.setPloName((String) o[3]);
//            spr.setSubjectCode((String)o[1]);
//            subjectPloResponses.add(spr);
//        }
//
//        return subjectPloResponses;
//
//    }

    @Override
    public List<SubjectPloMappingResponse> getSubjectPlo2(Integer curriculumId) {
        List<Subject> subjectList = subjectRepository.findSubjectByCurriculum(curriculumId);
        List<SubjectPloMappingResponse> subjectPloResponses = new ArrayList<>();

        for (Subject s: subjectList) {
            SubjectPloMappingResponse subjectPloMappingResponse = new SubjectPloMappingResponse();
            subjectPloMappingResponse.setSubjectId(s.getSubjectId());
            subjectPloMappingResponse.setSubjectCode(s.getSubjectCode());

            List<Object[]> plos = subjectRepository.getListPlo(s.getSubjectId());
            List<PloDto> ploDtoList = new ArrayList<>();

            for (Object[] o:plos) {
                PloDto ploDto = new PloDto();
                ploDto.setPloId((Integer) o[0]);
                ploDto.setPloName((String) o[1]);
                ploDtoList.add(ploDto);
            }
            subjectPloMappingResponse.setPloDtoList(ploDtoList);
            subjectPloResponses.add(subjectPloMappingResponse);
        }

        return subjectPloResponses;

    }

    @Override
    public List<SubjectVo> getAllSubject(String code) {
        List<SubjectVo> lstSubject = new ArrayList<>();
        if(code == null || code.equals("") ){
            lstSubject = subjectRepository.getAllSubject();
        } else {
            lstSubject = subjectRepository.getSubjectByCode(code);
        }
        if (lstSubject == null){
            return null;
        }
        return lstSubject;
    }

    @Override
    public List<SubjectVo> getAllSubjectNotElective() {
        List<SubjectVo> lstSubject = new ArrayList<>();
        List<Object[]> lstObject = new ArrayList<>();
        lstObject = subjectRepository.getAllSubjectNotElective();
        if (lstSubject == null){
            return null;
        }
        for (Object[] o: lstObject) {
            SubjectVo subject = new SubjectVo();
            subject.setSubjectId((Integer) o[0]);
            subject.setCredit((Integer) o[1]);
            subject.setSemester((Integer) o[3]);
            subject.setStatus((Integer) o[4]);
            subject.setSubjectCode((String) o[5]);
            subject.setSubjectName((String) o[6]);
            lstSubject.add(subject);
        }
        return lstSubject;
    }

}
