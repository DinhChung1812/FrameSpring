package doan.middle_project.controller;

import doan.middle_project.dto.Responds.PloResponse;
import doan.middle_project.service.PloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PloController {

    @Autowired
    PloService ploService;

    @GetMapping("/PloDetail")
    public List<PloResponse> getListPlo(@RequestParam(value = "Curriculum_code",required = false,defaultValue = " ") String CurriculumCode,
                                        @RequestParam(value = "status") Integer status){
        return ploService.getListPlo(CurriculumCode,status);
    }

}
