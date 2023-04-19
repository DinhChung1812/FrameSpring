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
public class SubjectVo {
    private Integer subjectId;

    private String subjectCode;

    private String subjectName;

    private String subjectNote;

    private Integer semester;

    private Integer credit;

update    private String preRequisite;

    private Integer status;

    public SubjectVo(Integer subjectId, String subjectCode, String subjectName, String subjectNote, Integer semester, Integer credit, String preRequisite) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.subjectNote = subjectNote;
        this.semester = semester;
        this.credit = credit;
        this.preRequisite = preRequisite;
    }
}
