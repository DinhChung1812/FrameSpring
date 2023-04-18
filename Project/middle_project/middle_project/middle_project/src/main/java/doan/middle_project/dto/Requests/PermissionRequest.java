package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class PermissionRequest {
    private Integer settingRoleId;
    private Integer settingPageId;
    private Boolean accessAll;
    private Boolean canRead;
    private Boolean canAdd;
    private Boolean canEdit;
}
