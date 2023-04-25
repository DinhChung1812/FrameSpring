package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.SyllabusVo;
import doan.middle_project.dto.Requests.SyllabusRequest;
import doan.middle_project.dto.Responds.SyllabusDto;
import doan.middle_project.dto.Responds.SyllabusResponse;
import doan.middle_project.entities.Decision;
import doan.middle_project.entities.Subject;
import doan.middle_project.entities.Syllabus;
import doan.middle_project.exception.ResponseException;
import doan.middle_project.repositories.DecisionRepository;
import doan.middle_project.repositories.PreRequisiteRepository;
import doan.middle_project.repositories.SubjectRepository;
import doan.middle_project.repositories.SyllabusRepository;
import doan.middle_project.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired
    SyllabusRepository syllabusRepository;

    @Autowired
    DecisionRepository decisionRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PreRequisiteRepository preRequisiteRepository;


    //1- subject code. 2-subject name
    @Override
    public List<SyllabusDto> getSyllabusList(Integer type, String textSearch) {

        List<Object[]> syllabusList = new ArrayList<>();

        textSearch.trim();

        if ((type == 1 && textSearch.isEmpty()) || type == 2 && textSearch.isEmpty()) {
            syllabusList = syllabusRepository.getAllSyllabus();
        } else if (type == 2 && textSearch != null) {
            syllabusList = syllabusRepository.getSyllabusBysubjectName(textSearch);
        } else if (type == 1 && !textSearch.isEmpty()) {
            syllabusList = syllabusRepository.getSyllabusBysubjectCode(textSearch);
        }

        List<SyllabusDto> syllabusDtoList = new ArrayList<>();

        for (Object[] s : syllabusList) {
            SyllabusDto syllabusDto = new SyllabusDto();
            syllabusDto.setSyllabusId((Integer) s[0]);
            syllabusDto.setSubjectCode((String) s[1]);
            syllabusDto.setSubjectName((String) s[2]);
            syllabusDto.setSyllabusName((String) s[3]);
            syllabusDto.setIsActive((boolean) s[4]);
            syllabusDto.setIsProved((boolean) s[5]);
            syllabusDto.setDecisionNo((String) s[6]);

            syllabusDtoList.add(syllabusDto);
        }

        return syllabusDtoList;

    }

//    @Override
//    public void addSyllabus(SyllabusRequest syllabusRequest) {
//
//        Syllabus s = syllabusRepository.findBySyllabusName(syllabusRequest.getSyllabusName());
//        if (s != null) {
//            throw new ResponseException("syllabus name dupplicate");
//        }
//
//        Decision decision = new Decision();
//        decision.setDecisionNo(syllabusRequest.getDecisionNo());
//        decision.setDecisionDate(syllabusRequest.getApprovedDate());
//        decisionRepository.save(decision);
//
//        Subject subject = subjectRepository.findBySubject_code(syllabusRequest.getSubjectCode());
//
//        Syllabus syllabus = new Syllabus();
//        syllabus.setDecision(decision);
//        syllabus.setSubjectId(subject);
//        syllabus.setSyllabusName(syllabusRequest.getSyllabusName());
//        syllabus.setTimeAllocation(syllabusRequest.getTimeAllocation());
//        syllabus.setSyllabusDescription(syllabusRequest.getSyllabusDescription());
//        syllabus.setScoringScale(syllabusRequest.getScoringScale());
//        syllabus.setMinAvgMarkToPass(syllabusRequest.getMinAvgMarkToPass());
//        syllabus.setDegreeLevel(syllabusRequest.getDegreeLevel());
//        syllabus.setStudentTasks(syllabusRequest.getStudentTasks());
//        syllabus.setNote(syllabusRequest.getNote());
//        syllabus.setIsActive(syllabusRequest.getIsActive());
//        syllabus.setIsProved(syllabusRequest.getIsProved());
//        syllabusRepository.save(syllabus);
//
//    }

    @Override
    public void addSyllabus(SyllabusRequest syllabusRequest) {

        Syllabus s = syllabusRepository.findBySyllabusName(syllabusRequest.getSyllabusName());
        if (s != null) {
            throw new ResponseException("syllabus name dupplicate");
        }

        Decision decision = new Decision();
        decision.setDecisionNo(syllabusRequest.getDecisionNo());
        decision.setDecisionDate(syllabusRequest.getApprovedDate());
        decisionRepository.save(decision);

        Subject subject = subjectRepository.findBySubject_code(syllabusRequest.getSubjectCode());

        Syllabus syllabus = new Syllabus();
        syllabus.setDecision(decision);
        syllabus.setSubjectId(subject);
        syllabus.setSyllabusName(syllabusRequest.getSyllabusName());
        syllabusRepository.save(syllabus);

    }

    @Override
    public void editSyllabus(SyllabusRequest syllabusRequest, Integer syllabusId) {

        Syllabus syllabus = syllabusRepository.getById(syllabusId);
        syllabus.setSyllabusName(syllabusRequest.getSyllabusName());
        syllabus.setTimeAllocation(syllabusRequest.getTimeAllocation());
        syllabus.setSyllabusDescription(syllabusRequest.getSyllabusDescription());
        syllabus.setScoringScale(syllabusRequest.getScoringScale());
        syllabus.setMinAvgMarkToPass(syllabusRequest.getMinAvgMarkToPass());
        syllabus.setDegreeLevel(syllabusRequest.getDegreeLevel());
        syllabus.setStudentTasks(syllabusRequest.getStudentTasks());
        syllabus.setNote(syllabusRequest.getNote());
        syllabus.setIsActive(syllabusRequest.getIsActive());
        syllabusRepository.save(syllabus);
    }

    @Override
    public SyllabusResponse getSyllabusDetail(Integer syllabusId) {

        Syllabus syllabus = syllabusRepository.getById(syllabusId);

        SyllabusResponse syllabusResponse = new SyllabusResponse();
        syllabusResponse.setSyllabusId(syllabus.getSyllabusId());
        syllabusResponse.setSyllabusName(syllabus.getSyllabusName());

        Subject subject = subjectRepository.getSubjectCodeAndNoCreadit(syllabus.getSubjectId().getSubjectId());
        syllabusResponse.setSubjectCode(subject.getSubjectCode());
        syllabusResponse.setNoCredit(subject.getCredit());


        syllabusResponse.setDegreeLevel(syllabus.getDegreeLevel());
        syllabusResponse.setTimeAllocation(syllabus.getTimeAllocation());
        syllabusResponse.setIsActive(syllabus.getIsActive());

        List<Object[]> preRequisiteList = preRequisiteRepository.getPreRequisiteBySubject_code(syllabus.getSubjectId().getSubjectId());
        List<String> pre = new ArrayList<>();
        for (Object[] p : preRequisiteList) {
            String s = "";
            s = (String) p[0];
            pre.add(s);
        }
        syllabusResponse.setPreRequisite(pre);


        syllabusResponse.setSyllabusDescription(syllabus.getSyllabusDescription());
        syllabusResponse.setStudentTasks(syllabus.getStudentTasks());
        syllabusResponse.setTool(syllabus.getTool());
        syllabusResponse.setScoringScale(syllabus.getScoringScale());

//        Decision decision = decisionRepository.getBySubjectId(syllabus.getSubjectId().getSubjectId());
        syllabusResponse.setDecisionNo(syllabus.getDecision().getDecisionNo());
        syllabusResponse.setApprovedDate(syllabus.getDecision().getDecisionDate());

        syllabusResponse.setNote(syllabus.getNote());
        syllabusResponse.setMinAvgMarkToPass(syllabus.getMinAvgMarkToPass());

        return syllabusResponse;

}

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
