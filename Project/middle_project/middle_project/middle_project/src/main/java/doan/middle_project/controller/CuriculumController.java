package doan.middle_project.controller;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.dto.Responds.SettingResponse;
import doan.middle_project.service.CuriculumService;
import doan.middle_project.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CuriculumController {
    @Autowired
    CuriculumService curiculumService;

    @GetMapping("/get_all_curiculum")
    public List<CuriculumVo> getAllCuriculum() {
        return curiculumService.getAllCuriculum();
    }
}
