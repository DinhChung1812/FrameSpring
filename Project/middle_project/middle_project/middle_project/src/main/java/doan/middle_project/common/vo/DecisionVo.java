package doan.middle_project.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DecisionVo {
    private Integer decisionId;

    private String decisionNo;

    private Date decisionDate;

    private String note;

    private Date createDate;

    private String fileName;

    private String decisionNewName;
}
