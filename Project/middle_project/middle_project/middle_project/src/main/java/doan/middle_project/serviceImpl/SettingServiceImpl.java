package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Requests.SettingEditRequest;
import doan.middle_project.dto.Requests.SettingRequest;
import doan.middle_project.dto.Responds.SettingResponse;
import doan.middle_project.entities.Setting;
import doan.middle_project.entities.UserRole;
import doan.middle_project.repositories.SettingRepository;
import doan.middle_project.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    SettingRepository settingRepository;

    @Override
    public List<SettingResponse> getListSetting(Integer role, Integer status, Integer pageIndex) {

        if (pageIndex == null || pageIndex <= 0) {
            pageIndex = 1;
        }
        Pageable pageable = PageRequest.of(pageIndex - 1, 5);

        List<Setting> settingList = settingRepository.findSettingByStatusAndUserRole(role,status,pageable);
        List<SettingResponse> settingResponseList = new ArrayList<>();

        for (Setting s: settingList) {
            SettingResponse sr = new SettingResponse();
            sr.setSettingId(s.getSettingId());
            sr.setName(s.getName());
            sr.setDescription(s.getDescription());
            sr.setDisplayOrder(s.getDisplayOrder());
            sr.setStatus(s.getStatus());
            sr.setType(s.getUserRole().getRole());
            settingResponseList.add(sr);
        }

        return settingResponseList;
    }

    @Override
    public void settingNew(SettingRequest settingRequest) {
        Setting s = new Setting();
        UserRole userRole = new UserRole();
        userRole.setRoleId(settingRequest.getType());

        s.setName(settingRequest.getName());
        s.setDisplayOrder(settingRequest.getDisplayOrder());
        s.setDescription(settingRequest.getDescription());
        s.setUserRole(userRole);
        s.setStatus(settingRequest.getStatus());
        settingRepository.save(s);
    }

    @Override
    public void settingEdit(Integer id, SettingEditRequest setting) {
        Setting s = settingRepository.findSettingBySettingId(id);
        UserRole userRole = new UserRole();
        userRole.setRoleId(setting.getType());

//        s.setSettingId(setting.getSettingId());
        s.setName(setting.getName());
        s.setDisplayOrder(setting.getDisplayOrder());
        s.setUserRole(userRole);
        s.setStatus(setting.getStatus());
        s.setDescription(setting.getDescription());

        settingRepository.save(s);
    }

    @Override
    public SettingResponse getSettingById(Integer settingId) {
        Setting setting = settingRepository.findById(settingId).orElseThrow(()->new RuntimeException());
        SettingResponse s = new SettingResponse();
        s.setSettingId(setting.getSettingId());
        s.setName(setting.getName());
        s.setDescription(setting.getDescription());
        s.setStatus(setting.getStatus());
        s.setDisplayOrder(setting.getDisplayOrder());
        s.setType(setting.getUserRole().getRole());
        s.setTypeId(setting.getUserRole().getRoleId());
        return  s;
    }

    @Override
    public void settingStatus(Integer settingId) {
        Setting s = settingRepository.findById(settingId).orElseThrow(()->new RuntimeException());
        if (s.getStatus()==1){
            s.setStatus(0);
        }else {
            s.setStatus(1);
        }
        settingRepository.save(s);
    }

}
