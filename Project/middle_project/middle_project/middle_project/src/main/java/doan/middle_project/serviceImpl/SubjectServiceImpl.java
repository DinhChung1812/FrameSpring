package doan.middle_project.serviceImpl;


import doan.middle_project.dto.Requests.SubjectRequest;
import doan.middle_project.dto.Responds.PloDto;
import doan.middle_project.dto.Responds.SubjectPloResponse;
import doan.middle_project.dto.Responds.SubjectPloMappingResponse;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.Subject;
import doan.middle_project.repositories.CurriculumRepository;
import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.SubjectVo;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.SubjectRepository;
import doan.middle_project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;


    @Autowired
    CurriculumRepository curriculumRepository;

    @Override
    public void createSubject(SubjectRequest subject) {
        Subject s = new Subject();
        s.setSubjectCode(subject.getSubjectCode());
        s.setSubjectName(subject.getSubjectName());
        s.setSubjectNote(subject.getSubjectNote());
        s.setSemester(subject.getSemester());
        s.setCredit(subject.getCredit());
        s.setPreRequisite(subject.getPreRequisite());
        s.setStatus(subject.getStatus());

        Curriculum c = curriculumRepository.findByCurriculumCode(subject.getCurriculumCode());
        s.setCurriculum(c);
        subjectRepository.save(s);
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

}
