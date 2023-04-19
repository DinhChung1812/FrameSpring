package doan.middle_project.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuriculumVo {
    private Integer curriculumId;

    private String curriculumCode;

    private String curriculumName;

    private String curriculumNameEnglish;

    private String description;

    private String descriptionNO;

    private Integer status;

    private Integer totalCredit;

    private List<PLOVo> lstPLO;
    private List<POVo> lstPO;
    private List<SubjectVo> lstSubject;

    public CuriculumVo(Integer curriculumId, String curriculumCode, String curriculumName, String curriculumNameEnglish, String description, String descriptionNO, Integer totalCredit) {
        this.curriculumId = curriculumId;
        this.curriculumCode = curriculumCode;
        this.curriculumName = curriculumName;
        this.curriculumNameEnglish = curriculumNameEnglish;
        this.description = description;
        this.descriptionNO = descriptionNO;
        this.totalCredit = totalCredit;
    }
}
