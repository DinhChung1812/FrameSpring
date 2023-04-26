package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class SessionRequest {
    private String sessionsCode;

    private String sessionsTopic;

    private Integer learningTeachingType;

    private String itu;

    private String studentMaterials;

    private String sDownload;

    private String studentTasks;

    private String url;
    private Integer syllabusId;
}
