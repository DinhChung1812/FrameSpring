package doan.middle_project.dto.Responds;

import lombok.Data;

@Data
public class PermissionResponse {

    private Integer settingRoleId;
    private Integer settingPageId;
    private String pageName;
    private String roleName;
    private Integer accessAll;
    private Integer canRead;
    private Integer canAdd;
    private Integer canEdit;

}
