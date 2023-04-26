package doan.middle_project.dto.Responds;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SessionResponse {
    private Integer sessionsId;

    private String sessionsCode;

    private String sessionsTopic;

    private Integer learningTeachingType;

    private String itu;

    private String studentMaterials;

    private String sDownload;

    private String studentTasks;

    private String url;
}
