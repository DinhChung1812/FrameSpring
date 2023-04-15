package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class SettingRequest {
    private String name;
    private String description;
    private Integer displayOrder;
    private Integer status;
    private Integer type;
}
