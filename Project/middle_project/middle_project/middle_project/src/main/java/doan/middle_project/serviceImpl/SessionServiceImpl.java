package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.QuestionVo;
import doan.middle_project.common.vo.SessionVo;
import doan.middle_project.dto.Requests.SessionRequest;
import doan.middle_project.dto.Responds.MessageResponse;
import doan.middle_project.dto.Responds.SessionResponse;
import doan.middle_project.entities.*;
import doan.middle_project.exception.NotFoundException;
import doan.middle_project.exception.StatusCode;
import doan.middle_project.repositories.QuestionRepository;
import doan.middle_project.repositories.SessionRepository;
import doan.middle_project.repositories.SyllabusRepository;
import doan.middle_project.service.QuestionService;
import doan.middle_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    SyllabusRepository syllabusRepository;

    @Override
    public ResponseEntity<?> getAllSession(Integer id_syllabus) {
        List<Object[]> lstObject = new ArrayList<>();
        List<SessionVo>  lstSession = new ArrayList<>();
        if(id_syllabus == null || id_syllabus.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
            lstObject = sessionRepository.getSessionBySyllabus(id_syllabus);
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

    @Override
    public ResponseEntity<?> getSessionDetail(Integer id_session) {
        Sessions session = new Sessions();
        SessionResponse sessionResponse = new SessionResponse();
        List<SessionVo>  lstSession = new ArrayList<>();
        if(id_session == null || id_session.equals("") ){
            return new ResponseEntity<>("Code bị null", HttpStatus.NOT_FOUND);
        } else {
            session = sessionRepository.getSessionDetail(id_session);
        }
        sessionResponse.setSessionsId(session.getSessionsId());
        sessionResponse.setSessionsCode(session.getSessionsCode());
        sessionResponse.setSessionsTopic(session.getSessionsTopic());
        sessionResponse.setLearningTeachingType(session.getLearningTeachingType());
        sessionResponse.setItu(session.getItu());
        sessionResponse.setStudentMaterials(session.getStudentMaterials());
        sessionResponse.setSDownload(session.getSDownload());
        sessionResponse.setStudentTasks(session.getStudentTasks());
        sessionResponse.setUrl(session.getUrl());
        return ResponseEntity.ok(sessionResponse);
    }

    @Override
    public ResponseEntity<?> updateInsertSession(Integer sessionId, SessionRequest sessionRequest) {
        Sessions session = new Sessions();
        Syllabus syllabus = new Syllabus();
        String mess = "";
        if( sessionId > 0){
            session = sessionRepository.findById(sessionId).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy session : "+sessionId+"!!!"));
            mess = "Cập nhật session: " + sessionId;
        } else {
            mess = "Thêm session";
        }

        if( sessionRequest.getSyllabusId() != null || !sessionRequest.getSyllabusId().equals("")){
            syllabus = syllabusRepository.findById(sessionRequest.getSyllabusId()).orElseThrow(() -> new NotFoundException(StatusCode.Not_Found,"Không tìm thấy Syllabu: "+sessionRequest.getSyllabusId()+"!!!"));
        }

        if(sessionId < 0){
            Sessions sessionDetail = sessionRepository.getSessionDetailByCode(sessionRequest.getSessionsCode());
            if (sessionDetail != null){
                return new ResponseEntity<>("Session code bị trùng", HttpStatus.NOT_FOUND);
            }
        }
        session.setSessionsCode(sessionRequest.getSessionsCode());
        session.setSessionsTopic(sessionRequest.getSessionsTopic());
        session.setLearningTeachingType(sessionRequest.getLearningTeachingType());
        session.setItu(sessionRequest.getItu());
        session.setStudentMaterials(sessionRequest.getStudentMaterials());
        session.setSDownload(sessionRequest.getSDownload());
        session.setStudentTasks(sessionRequest.getStudentTasks());
        session.setUrl(sessionRequest.getUrl());
        session.setSyllabus(syllabus);
        sessionRepository.save(session);
        return ResponseEntity.ok(new MessageResponse(StatusCode.Success,mess +" thành công"));
    }
}
