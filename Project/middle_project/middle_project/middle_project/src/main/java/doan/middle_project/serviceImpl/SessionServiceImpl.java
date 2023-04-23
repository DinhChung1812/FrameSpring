package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.QuestionVo;
import doan.middle_project.common.vo.SessionVo;
import doan.middle_project.repositories.QuestionRepository;
import doan.middle_project.repositories.SessionRepository;
import doan.middle_project.service.QuestionService;
import doan.middle_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public ResponseEntity<?> getAllSession(String code) {
        List<Object[]> lstObject = new ArrayList<>();
        List<SessionVo>  lstSession = new ArrayList<>();
        if(code == null || code.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
            lstObject = sessionRepository.getSessionBySyllabus(code.trim());
            for (Object[] o: lstObject) {
                SessionVo session = new SessionVo();
                session.setSessionsId((Integer) o[0]);
                session.setSessionsCode((String) o[1]);
                session.setSessionsTopic((String) o[2]);
                session.setLearningTeachingType((Integer) o[3]);
                session.setItu((String) o[4]);
                session.setStudentMaterials((String) o[5]);
                session.setSDownload((String) o[6]);
                session.setStudentTasks((String) o[7]);
                session.setUrl((String) o[8]);
                lstSession.add(session);
            }
        }
//        Map<String, List<AssessmentVo>> lstElectiveGrouped =
//                lstElective.stream().collect(Collectors.groupingBy(w -> w.()));
        return ResponseEntity.ok(lstSession);
    }
}
