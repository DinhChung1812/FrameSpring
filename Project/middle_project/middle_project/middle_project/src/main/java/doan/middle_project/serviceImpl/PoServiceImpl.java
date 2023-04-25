package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Responds.PoDto;
import doan.middle_project.dto.Responds.PoResponse;
import doan.middle_project.entities.Curriculum;
import doan.middle_project.entities.PO;
import doan.middle_project.exception.ResponseException;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.PORepository;
import doan.middle_project.service.PoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoServiceImpl implements PoService {

    @Autowired
    PORepository poRepository;

    @Autowired
    CuriculumRepository curiculumRepository;

    @Override
    public ResponseEntity<?> getPoDetail(String curriculumCode, Integer status) {

        curriculumCode.trim();

        if (curriculumCode.isEmpty()||curriculumCode==null){
             throw new ResponseException("not found");
        }else {
            Curriculum curriculum = curiculumRepository.findByCurriculumCode(curriculumCode);

            if (curriculum==null){
                throw new ResponseException("not found");
            }

            PoResponse poResponse = new PoResponse();
            poResponse.setCurriculumCode(curriculum.getCurriculumCode());
            poResponse.setCurriculumName(curriculum.getCurriculumName());

            List<PO> poList = poRepository.getPOByCurriculumCode(curriculumCode,status);
            List<PoDto> poDtoList = new ArrayList<>();

            for (PO po : poList) {
                PoDto poDto = new PoDto();
                poDto.setPoId(po.getPoId());
                poDto.setPoName(po.getPoName());
                poDto.setPoDescription(po.getPoDescription());
                poDtoList.add(poDto);
            }

            poResponse.setPoDtoList(poDtoList);

            return new ResponseEntity(poResponse,HttpStatus.OK) ;
        }
    }
}
