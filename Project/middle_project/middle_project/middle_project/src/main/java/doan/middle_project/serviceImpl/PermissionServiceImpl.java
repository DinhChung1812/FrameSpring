package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Requests.PermissionRequest;
import doan.middle_project.dto.Responds.PermissionResponse;
import doan.middle_project.entities.Permission;
import doan.middle_project.repositories.PermissionRepository;
import doan.middle_project.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public List<PermissionResponse> getRolePermissionList() {
        List<Permission> permissionList = permissionRepository.findAll();
        List<PermissionResponse> permissionResponseList = new ArrayList<>();

        for (Permission p: permissionList) {
            PermissionResponse pr = new PermissionResponse();
            pr.setSettingRoleId(p.getSettingRoleId().getSettingId());
            pr.setSettingPageId(p.getSettingPageId().getSettingId());
            pr.setPageName(p.getSettingPageId().getName());
            pr.setRoleName(p.getSettingRoleId().getName());
            pr.setAccessAll(p.getAccessAll());
            pr.setCanRead(p.getCanRead());
            pr.setCanAdd(p.getCanAdd());
            pr.setCanEdit(p.getCanEdit());
            permissionResponseList.add(pr);
        }

        return permissionResponseList;

    }

    @Override
    public void updateRolePermission(List<PermissionRequest> permissionResponseLists) {
        for (PermissionRequest pr: permissionResponseLists) {
            Permission p = permissionRepository.findPermissionByRoleIdAndPageId(pr.getSettingRoleId(), pr.getSettingPageId());
            p.setAccessAll(pr.getAccessAll());
            p.setCanRead(pr.getCanRead());
            p.setCanAdd(pr.getCanAdd());
            p.setCanEdit(pr.getCanEdit());
            permissionRepository.save(p);
        }
    }
}
