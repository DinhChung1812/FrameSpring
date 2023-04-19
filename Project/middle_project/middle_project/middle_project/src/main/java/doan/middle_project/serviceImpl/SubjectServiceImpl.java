package doan.middle_project.serviceImpl;

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
