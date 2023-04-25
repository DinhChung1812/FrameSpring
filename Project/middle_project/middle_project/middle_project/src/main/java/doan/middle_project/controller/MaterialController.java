package doan.middle_project.controller;

import doan.middle_project.dto.Responds.MaterialDto;
import doan.middle_project.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @GetMapping("/getListMaterial")
    public List<MaterialDto> getListMaterial(){
        return materialService.getListMaterial();
    }

    @GetMapping("/getMaterialDetail")
    public MaterialDto getMaterialDetail(@RequestParam("material_id")Integer  materialId){
        return materialService.getMaterialDetail(materialId);
    }



}
