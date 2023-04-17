package doan.middle_project.controller;

import doan.middle_project.dto.Requests.SettingEditRequest;
import doan.middle_project.dto.Requests.SettingRequest;
import doan.middle_project.dto.Responds.SettingResponse;
import doan.middle_project.entities.Permission;
import doan.middle_project.entities.Setting;
import doan.middle_project.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SettingController {

    @Autowired
    SettingService settingService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/getSettingList")
//    public List<SettingResponse> getSettingList(){
//        return settingService.getListSetting();
//    }

    @GetMapping("/getSettingList")
    public List<SettingResponse> getSettingList(@RequestParam(value = "type",required = false)Integer type, @RequestParam(value = "status",required = false)Integer status, @RequestParam(value = "name",required = false)String name){
        return settingService.getListSetting(type,status,name);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/newSetting")
    public void newSetting(@RequestBody SettingRequest settingRequest){
        settingService.settingNew(settingRequest);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editSetting")
    public void editSetting(@RequestParam("setting_id") Integer id  ,@RequestBody SettingEditRequest setting){
        settingService.settingEdit(id,setting);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getSettingById")
    public SettingResponse getSettingById(@RequestParam("setting_id") Integer settingId){
        return settingService.getSettingById(settingId);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/updateSettingStatus")
    public void updateSettingStatus(@RequestParam("setting_id") Integer settingId){
        settingService.settingStatus(settingId);
    }


}
