package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Responds.CloPloMappingResponse;
import doan.middle_project.dto.Responds.CloResponse;
import doan.middle_project.entities.CLO;
import doan.middle_project.repositories.CloRepository;
import doan.middle_project.service.CloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CloServiceImpl implements CloService {

    @Autowired
    CloRepository cloRepository;

    @Override
    public List<CloResponse> getCloList() {
        List<CLO> cloList = cloRepository.findAll();
        List<CloResponse> cloResponseList = new ArrayList<>();

//        for (CLO clo: cloList) {
//            CloResponse cloResponse = new CloResponse();
//            cloResponse.setCloId();
//            cloResponse.setSubjectCode();
//            cloResponse.setSyllabusName();
//            cloResponse.setLoDetails();
//            cloResponse.set
//        }
        return cloResponseList;
    }

    @Override
    public List<CloPloMappingResponse> getCloPloMapping(String subjectCode) {
        List<Object[]> cloPloMappingList = cloRepository.getCloPloMapping(subjectCode);
        List<CloPloMappingResponse> cloPloMappingResponseList = new ArrayList<>();
        for (Object[] o: cloPloMappingList) {
            CloPloMappingResponse cloPloMappingResponse = new CloPloMappingResponse();
            cloPloMappingResponse.setCloId((Integer) o[0]);
            cloPloMappingResponse.setCloName((String) o[1]);
            cloPloMappingResponse.setPloId((Integer) o[2]);
            cloPloMappingResponse.setPloName((String) o[3]);
            cloPloMappingResponseList.add(cloPloMappingResponse);
        }
        return cloPloMappingResponseList;
    }
}
