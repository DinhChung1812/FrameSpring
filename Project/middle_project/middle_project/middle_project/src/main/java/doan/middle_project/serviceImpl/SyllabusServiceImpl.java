package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Responds.SyllabusDto;
import doan.middle_project.entities.Syllabus;
import doan.middle_project.repositories.SyllabusRepository;
import doan.middle_project.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired
    SyllabusRepository syllabusRepository;


    //1- subject code. 2-subject name
    @Override
    public List<SyllabusDto> getSyllabusList(Integer type, String textSearch) {

        List<Object[]> syllabusList = new ArrayList<>();

        if (type == 1) {
            syllabusList = syllabusRepository.getSyllabusBysubjectCode(textSearch);
        } else if (type == 2) {
            syllabusList = syllabusRepository.getSyllabusBysubjectName(textSearch);
        }

        List<SyllabusDto> syllabusDtoList = new ArrayList<>();

        for (Object[] s: syllabusList){
            SyllabusDto syllabusDto = new SyllabusDto();
            syllabusDto.setSyllabusId((Integer) s[0]);
            syllabusDto.setSubjectCode((String) s[1]);
            syllabusDto.setSubjectName((String)s[2]);
            syllabusDto.setSyllabusName((String)s[3]);
            syllabusDto.setIsActive((boolean) s[4]);
            syllabusDto.setIsProved((boolean) s[5]);
            syllabusDto.setDecisionNo((String) s[6]);

            syllabusDtoList.add(syllabusDto);
        }

        return syllabusDtoList;

    }
}
