package doan.middle_project.dto.Responds;

import lombok.Data;

import java.util.List;

@Data
public class ElectiveResponse {
    private String EletiveCode;
    private String EletiveName;
    private List<SubjectResponse> listSubject;
}


