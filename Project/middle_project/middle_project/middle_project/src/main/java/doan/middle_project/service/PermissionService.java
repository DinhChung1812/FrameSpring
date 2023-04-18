package doan.middle_project.service;

import doan.middle_project.dto.Requests.PermissionRequest;
import doan.middle_project.dto.Responds.PermissionResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PermissionService {
    List<PermissionResponse> getRolePermissionList();

    void updateRolePermission(List<PermissionRequest> permissionResponseLists);
}
