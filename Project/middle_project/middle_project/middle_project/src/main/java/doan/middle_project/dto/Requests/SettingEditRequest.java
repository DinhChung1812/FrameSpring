package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class SettingEditRequest {
    private Integer settingId;
    private String name;
    private String description;
    private int displayOrder;
    private Integer status;
    private Integer type;
}
