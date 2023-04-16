package doan.middle_project.controller;

import doan.middle_project.dto.Requests.SettingEditRequest;
import doan.middle_project.dto.Requests.SettingRequest;
import doan.middle_project.dto.Responds.SettingResponse;
import doan.middle_project.entities.Setting;
import doan.middle_project.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SettingController {

    @Autowired
    SettingService settingService;

    @GetMapping("/getSettingList")
    public List<SettingResponse> getSettingList(@RequestParam("role")Integer role, @RequestParam("status")Integer status, @RequestParam(value = "page_index",required = false)Integer pageIndex){
        return settingService.getListSetting(role,status,pageIndex);
    }

    @PostMapping("/newSetting")
    public void newSetting(@RequestBody SettingRequest settingRequest){
        settingService.settingNew(settingRequest);
    }

    @PutMapping("/editSetting")
    public void editSetting(@RequestBody SettingEditRequest setting){
        settingService.settingEdit(setting);
    }

    @GetMapping("/getSettingById")
    public SettingResponse getSettingById(@RequestParam("setting_id") Integer settingId){
        return settingService.getSettingById(settingId);
    }

    @PutMapping("/updateSettingStatus")
    public void updateSettingStatus(@RequestParam("setting_id") Integer settingId){
        settingService.settingStatus(settingId);
    }


}
