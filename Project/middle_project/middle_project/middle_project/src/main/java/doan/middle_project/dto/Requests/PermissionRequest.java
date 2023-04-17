package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class PermissionRequest {
    private Integer settingRoleId;
    private Integer settingPageId;
    private Integer accessAll;
    private Integer canRead;
    private Integer canAdd;
    private Integer canEdit;
}
