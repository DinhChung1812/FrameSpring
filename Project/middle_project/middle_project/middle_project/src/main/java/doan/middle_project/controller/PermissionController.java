package doan.middle_project.controller;

import doan.middle_project.dto.Requests.PermissionRequest;
import doan.middle_project.dto.Responds.PermissionResponse;
import doan.middle_project.entities.Permission;
import doan.middle_project.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/getListRolePermission")
    public List<PermissionResponse> getListRolePermission(){
        return permissionService.getRolePermissionList();
    }

    @PutMapping("/updateRolePermission")
    public void updateRolePermission(@RequestBody List<PermissionRequest> permissionResponseLists){
        permissionService.updateRolePermission(permissionResponseLists);
    }

}
