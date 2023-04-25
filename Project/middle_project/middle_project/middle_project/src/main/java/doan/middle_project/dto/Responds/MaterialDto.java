package doan.middle_project.dto.Responds;

import lombok.Data;

@Data
public class MaterialDto {
    private Integer materialId;
    private String materialDescription;
    private String author;
    private String publisher;
    private Integer publishedDate;
    private Integer edition;
    private String isbn;
    private boolean isMainMaterial;
    private boolean isHardCopy;
    private boolean isOnline;
    private String note;

}
