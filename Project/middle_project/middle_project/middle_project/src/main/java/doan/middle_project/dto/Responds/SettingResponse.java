package doan.middle_project.dto.Responds;

import lombok.Data;

@Data
public class SettingResponse {
    private Integer settingId;
    private String name;
    private String description;
    private int displayOrder;
    private Integer status;
    private Integer type;
}
