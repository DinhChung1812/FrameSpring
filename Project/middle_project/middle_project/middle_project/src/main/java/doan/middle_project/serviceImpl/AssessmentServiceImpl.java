package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.AssessmentVo;
import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.ElectiveVo;
import doan.middle_project.dto.Requests.AssessmentRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.entities.*;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.*;
import doan.middle_project.service.AssessmentService;
import doan.middle_project.service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;

    @Autowired
    CuriculumRepository curiculumRepository;

    @Autowired
    AssessmentCategoryRepository assessmentCategoryRepository;

    @Autowired
    SyllabusRepository syllabusRepository;

    @Override
    public ResponseEntity<?> getAllAssessment(String code) {
        List<Object[]> lstObject = new ArrayList<>();
        List<AssessmentVo>  lstAssessment = new ArrayList<>();
        if(code == null || code.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
//            List<CuriculumVo> lst = curiculumRepository.getCuriculumByCode(code);
//            if (lst.size() == 0){
//                return new ResponseEntity<>("Không tồn tại curriculum: " + code, HttpStatus.NOT_FOUND);
//            }
            lstObject = assessmentRepository.getAssessmentBySubject(code.trim());
            for (Object[] o: lstObject) {
                AssessmentVo assessment = new AssessmentVo();
                assessment.setAssessmentId((Integer) o[0]);
                assessment.setAssessment_category((String) o[1]);
                assessment.setType((String) o[2]);
                assessment.setPart((Integer) o[3]);
                assessment.setWeight((String) o[4]);
                assessment.setCompletionCriteria((String) o[5]);
                assessment.setDuration((Integer) o[6]);
                assessment.setQuestionType((String) o[7]);
                assessment.setQuestionNo((String) o[8]);
                assessment.setKnowledgeSkill((String) o[9]);
                assessment.setGradingGuide((String) o[10]);
                assessment.setNote((String) o[11]);
                lstAssessment.add(assessment);
            }
        }
//        Map<String, List<AssessmentVo>> lstElectiveGrouped =
//                lstElective.stream().collect(Collectors.groupingBy(w -> w.()));
        return ResponseEntity.ok(lstAssessment);
    }

    @Override
    public ResponseEntity<?> UpdateInsertAssessment(Integer assessmentId, AssessmentRequest assessmentRequest) {
        Assessment assessment = new Assessment();
        Syllabus syllabus = new Syllabus();
        AssessmentCategory assessmentCategory = new AssessmentCategory();
        String mess = "";
        if( assessmentId > 0){
            assessment = assessmentRepository.findById(assessmentId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy assessment: "+assessmentId+"!!!"));
            mess = "Cập nhật assessment: " + assessmentId;
        } else {
            mess = "Thêm assessment";
        }

        if( assessmentRequest.getSyllabusId() != null || !assessmentRequest.getSyllabusId().equals("")){
            syllabus = syllabusRepository.findById(assessmentRequest.getSyllabusId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy syllabus: "+assessmentRequest.getSyllabusId()+"!!!"));
        }

        if( assessmentRequest.getAssessmentCateId() != null || !assessmentRequest.getAssessmentCateId().equals("")){
            assessmentCategory = assessmentCategoryRepository.findById(assessmentRequest.getAssessmentCateId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy assessment cate: "+assessmentRequest.getAssessmentCateId() +"!!!"));
        }


        assessment.setType(assessmentRequest.getType());
        assessment.setPart(assessmentRequest.getPart());
        assessment.setWeight(assessmentRequest.getWeight());
        assessment.setCompletionCriteria(assessmentRequest.getCompletionCriteria());
        assessment.setDuration(assessmentRequest.getDuration());
        assessment.setQuestionType(assessmentRequest.getQuestionType());
        assessment.setQuestionNo(assessmentRequest.getQuestionNo());
        assessment.setKnowledgeSkill(assessmentRequest.getKnowledgeSkill());
        assessment.setGradingGuide(assessmentRequest.getGradingGuide());
        assessment.setNote(assessmentRequest.getNote());
        Set<Syllabus> setSyllabus = new HashSet<Syllabus>();
        setSyllabus.add(syllabus);
        assessment.setSyllabusId(setSyllabus);
        assessment.setAssessmentCateId(assessmentCategory);
        assessmentRepository.save(assessment);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
    }
}
