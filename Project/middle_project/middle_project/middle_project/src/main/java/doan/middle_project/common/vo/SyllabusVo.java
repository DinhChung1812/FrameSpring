package doan.middle_project.common.vo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SyllabusVo {
    private Integer syllabusId;

    private String syllabusCode;
    private String syllabusDescription;

    private String syllabusName;


}
