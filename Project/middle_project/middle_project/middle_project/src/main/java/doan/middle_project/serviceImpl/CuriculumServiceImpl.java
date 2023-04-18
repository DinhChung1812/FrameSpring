package doan.middle_project.serviceImpl;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.repositories.CuriculumRepository;
import doan.middle_project.repositories.SettingRepository;
import doan.middle_project.service.CuriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuriculumServiceImpl implements CuriculumService {
    @Autowired
    CuriculumRepository _curiculumRepository;
    @Override
    public List<CuriculumVo> getAllCuriculum() {
        return null;
    }
}
