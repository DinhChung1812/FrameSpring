package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.AssessmentVo;
import doan.middle_project.common.vo.SyllabusVo;
import doan.middle_project.dto.Requests.AssessmentRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.entities.Assessment;
import doan.middle_project.entities.AssessmentCategory;
import doan.middle_project.entities.Syllabus;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.AssessmentCategoryRepository;
import doan.middle_project.repositories.AssessmentRepository;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.SyllabusRepository;
import doan.middle_project.service.AssessmentService;
import doan.middle_project.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired
    SyllabusRepository syllabusRepository;

    @Override
    public ResponseEntity<?> getSyllabusById(Integer id_syllabus) throws ParseException {
        List<Object[]> lstObject = new ArrayList<>();
        List<SyllabusVo>  lstSyllabus = new ArrayList<>();
        if(id_syllabus == null || id_syllabus.equals("") ){
            lstObject = syllabusRepository.getSyllabus();
        } else {
            lstObject = syllabusRepository.getSyllabusById(id_syllabus);
        }
        if(lstObject.size() == 0){
            return new ResponseEntity<>("Không tồn tại Syllabus nào phù hợp", HttpStatus.NOT_FOUND);
        }
        for (Object[] o: lstObject) {
            SyllabusVo assessment = new SyllabusVo();
            assessment.setSyllabusId((Integer) o[0]);
            assessment.setSubjectCode((String) o[1]);
            assessment.setSubjectName((String) o[2]);
            assessment.setSyllabusName((String) o[3]);
            assessment.setIsActive((Integer) o[4]);
            assessment.setIsProved((Integer) o[5]);
            assessment.setDecisionDate((Date) o[6]);
            assessment.setDecisionNo((String) o[7]);
            assessment.setDecisionNoNew((String) o[7] + " dated " + ((Date) o[6]).toString());
            lstSyllabus.add(assessment);
        }
        return ResponseEntity.ok(lstSyllabus);
    }
}
