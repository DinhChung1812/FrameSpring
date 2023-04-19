package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.dto.Responds.CurriculumResponse;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.repositories.CurriculumRepository;
import doan.middle_project.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    CurriculumRepository curriculumRepository;

    @Override
    public void createCurriculum(CurriculumRequest curriculumRequest) {
        Curriculum c = new Curriculum();
        c.setCurriculumCode(curriculumRequest.getCurriculumCode());
        c.setCurriculumName(curriculumRequest.getCurriculumName());
        c.setCurriculumNameEnglish(curriculumRequest.getCurriculumNameEnglish());
        c.setDescription(curriculumRequest.getDescription());
        c.setDescriptionNO(curriculumRequest.getDescriptionNO());
        c.setStatus(1);
        curriculumRepository.save(c);

    }

    @Override
    public CurriculumResponse curriculumDetail(Integer curriculumId) {
        Curriculum c = curriculumRepository.getById(curriculumId);
        CurriculumResponse cr = new CurriculumResponse();
        cr.setCurriculumCode(c.getCurriculumCode());
        cr.setCurriculumName(c.getCurriculumName());
        cr.setCurriculumNameEnglish(c.getCurriculumNameEnglish());
        cr.setDescription(c.getDescription());
        cr.setDescriptionNO(c.getDescriptionNO());

        return  cr;
    }
}
