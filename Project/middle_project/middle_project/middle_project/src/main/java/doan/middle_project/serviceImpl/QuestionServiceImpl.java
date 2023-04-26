package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.AssessmentVo;
import doan.middle_project.common.vo.QuestionVo;
import doan.middle_project.common.vo.SessionVo;
import doan.middle_project.dto.Requests.QuestionRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.dto.Responds.QuestionResponse;
import doan.middle_project.dto.Responds.SessionResponse;
import doan.middle_project.entities.Questions;
import doan.middle_project.entities.Sessions;
import doan.middle_project.entities.Syllabus;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.AssessmentRepository;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.QuestionRepository;
import doan.middle_project.repositories.SessionRepository;
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

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public ResponseEntity<?> getAllQuestionBySession(Integer sessionId) {
        List<Object[]> lstObject = new ArrayList<>();
        List<QuestionVo>  lstQuestion = new ArrayList<>();
        if(sessionId == null || sessionId.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
            lstObject = questionRepository.getAllQuestionBySession(sessionId);
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

    @Override
    public ResponseEntity<?> getQuestionDetail(Integer id_question) {
        Questions question = new Questions();
        QuestionResponse questionResponse = new QuestionResponse();
        if(id_question == null || id_question.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
            question = questionRepository.getQuestionDetail(id_question);
        }
        questionResponse.setQuestionsId(question.getQuestionsId());
        questionResponse.setQuestionsName(question.getQuestionsName());
        questionResponse.setQuestionsDetail(question.getQuestionsDetail());
        return ResponseEntity.ok(questionResponse);
    }

    @Override
    public ResponseEntity<?> updateInsertQuestion(Integer id_question, QuestionRequest questionRequest) {
        Sessions session = new Sessions();
        Questions questions = new Questions();
        String mess = "";
        if( id_question > 0){
            questions = questionRepository.findById(id_question).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy question : "+id_question+"!!!"));
            mess = "Cập nhật question: " + id_question;
        } else {
            mess = "Thêm question";
        }

        if( questionRequest.getSessionId() != null || !questionRequest.getSessionId().equals("")){
            session = sessionRepository.findById(questionRequest.getSessionId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy session: "+questionRequest.getSessionId()+"!!!"));
        }

        questions.setQuestionsName(questionRequest.getQuestionsName());
        questions.setQuestionsDetail(questionRequest.getQuestionsDetail());
        questions.setSessions(session);
        questionRepository.save(questions);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
    }
}
