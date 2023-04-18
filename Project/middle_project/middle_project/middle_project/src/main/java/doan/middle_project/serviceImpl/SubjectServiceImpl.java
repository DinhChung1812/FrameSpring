package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Requests.SubjectRequest;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.Subject;
import doan.middle_project.repositories.CurriculumRepository;
import doan.middle_project.repositories.SubjectRepository;
import doan.middle_project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
