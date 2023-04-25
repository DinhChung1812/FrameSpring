package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.AssessmentVo;
import doan.middle_project.common.vo.QuestionVo;
import doan.middle_project.entities.Questions;
import doan.middle_project.repositories.AssessmentRepository;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.QuestionRepository;
import doan.middle_project.service.AssessmentService;
import doan.middle_project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public ResponseEntity<?> getAllQuestion(String code) {
        List<Object[]> lstObject = new ArrayList<>();
        List<QuestionVo>  lstQuestion = new ArrayList<>();
        if(code == null || code.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
            lstObject = questionRepository.getQuestionBySyllabus(code.trim());
            for (Object[] o: lstObject) {
                QuestionVo assessment = new QuestionVo();
                assessment.setQuestionsId((Integer) o[0]);
                assessment.setQuestionsName((String) o[1]);
                assessment.setQuestionsDetail((String) o[2]);
                lstQuestion.add(assessment);
            }
        }
//        Map<String, List<AssessmentVo>> lstElectiveGrouped =
//                lstElective.stream().collect(Collectors.groupingBy(w -> w.()));
        return ResponseEntity.ok(lstQuestion);
    }
}
