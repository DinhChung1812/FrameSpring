package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Responds.PloResponse;
import doan.middle_project.entities.PLO;
import doan.middle_project.exception.ResponseException;
import doan.middle_project.repositories.PLORepository;
import doan.middle_project.service.PloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PloServiceImpl implements PloService {

    @Autowired
    PLORepository ploRepository;

    @Override
    public List<PloResponse> getListPlo(String curriculumCode) {

        if (curriculumCode.isEmpty() || curriculumCode==null) {
            throw new ResponseException("not found");
        }
            List<PLO> ploList = ploRepository.findByCurriculumCode(curriculumCode);

            if (ploList.isEmpty() || ploList == null) {
                throw new ResponseException("not found");
            }

            List<PloResponse> ploResponseList = new ArrayList<>();

            for (PLO plo : ploList) {
                PloResponse ploResponse = new PloResponse();
                ploResponse.setPloId(plo.getPloId());
                ploResponse.setPloName(plo.getPloName());
                ploResponse.setPloDescription(plo.getPloDescription());
                ploResponseList.add(ploResponse);
            }
            return ploResponseList;

    }
}
