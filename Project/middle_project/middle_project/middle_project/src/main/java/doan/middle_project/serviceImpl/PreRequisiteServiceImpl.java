package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Responds.PreRequisiteDto;
import doan.middle_project.repositories.PreRequisiteRepository;
import doan.middle_project.service.PreRequisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class PreRequisiteServiceImpl implements PreRequisiteService {

    @Autowired
    PreRequisiteRepository preRequisiteRepository;

    @Override
    public List<PreRequisiteDto> getPreRequisite(String subjectCode) {
        List<Object[]> preRequisite = preRequisiteRepository.getPreRequisite(subjectCode);
        List<PreRequisiteDto> preRequisiteDtoList = new ArrayList<>();
        PreRequisiteDto preRequisiteDto = new PreRequisiteDto();
        for (Object[] o: preRequisite) {
            preRequisiteDto.setSyllabusId((Integer) o[0]);
            preRequisiteDto.setSubjectCode((String) o[1]);
            preRequisiteDto.setSyllabusName((String) o[2]);
            preRequisiteDto.setDecisionNo((String)o[3]);
        }

        List<Object[]> preRequisiteOf = preRequisiteRepository.getPreRequisiteOf(subjectCode);
        List<String> learnAfter = new ArrayList<>();
        for (Object[] o1: preRequisiteOf) {
            String s = (String) o1[0];
            learnAfter.add(s);
        }
        preRequisiteDto.setLearnAfter(learnAfter);
        preRequisiteDtoList.add(preRequisiteDto);
        return preRequisiteDtoList;
    }
}
