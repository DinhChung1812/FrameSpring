package doan.middle_project.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectiveVo {

    private Integer electiveId;

    private String electiveCode;

    private String electiveName;

    private String subjectName;

    private String subjectCode;
}
