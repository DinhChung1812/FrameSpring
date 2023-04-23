package doan.middle_project.controller;

import doan.middle_project.dto.Responds.CloPloMappingResponse;
import doan.middle_project.dto.Responds.CloResponse;
import doan.middle_project.service.CloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CloController {

    @Autowired
    CloService cloService;

    @GetMapping("/getCloList")
    public List<CloResponse> getCloList(){
        return cloService.getCloList();
    }

    @GetMapping("/cloPloMapping")
    public List<CloPloMappingResponse> getCloPloMapping(@RequestParam("subject_code")String subjectCode){
        return cloService.getCloPloMapping(subjectCode);
    }

}
