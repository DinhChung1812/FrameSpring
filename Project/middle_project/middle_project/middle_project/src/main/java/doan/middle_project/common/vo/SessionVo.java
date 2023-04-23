package doan.middle_project.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionVo {
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
