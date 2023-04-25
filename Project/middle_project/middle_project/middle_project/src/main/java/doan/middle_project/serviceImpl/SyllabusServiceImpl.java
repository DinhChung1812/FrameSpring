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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired
    SyllabusRepository syllabusRepository;

    @Override
    public ResponseEntity<?> getSyllabusById(Integer id_syllabus) {
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
            assessment.setSyllabusCode((String) o[1]);
            assessment.setSyllabusDescription((String) o[2]);
            assessment.setSyllabusName((String) o[3]);
            lstSyllabus.add(assessment);
        }
        return ResponseEntity.ok(lstSyllabus);
    }
}
