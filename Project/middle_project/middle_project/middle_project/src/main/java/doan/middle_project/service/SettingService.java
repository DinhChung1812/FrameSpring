package doan.middle_project.service;

import doan.middle_project.dto.Requests.SettingEditRequest;
import doan.middle_project.dto.Requests.SettingRequest;
import doan.middle_project.dto.Responds.SettingResponse;

import java.util.List;

public interface SettingService {
    List<SettingResponse> getListSetting();

//    List<SettingResponse> getListSetting(Integer role, Integer status, Integer pageIndex);

    void settingNew(SettingRequest settingRequest);

    void settingEdit(Integer id, SettingEditRequest setting);

    SettingResponse getSettingById(Integer settingId);

    void settingStatus(Integer settingId);
}

