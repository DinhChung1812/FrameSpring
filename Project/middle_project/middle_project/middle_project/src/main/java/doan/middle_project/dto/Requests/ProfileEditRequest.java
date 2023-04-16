package doan.middle_project.dto.Requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileEditRequest {

    private String name;

    private String email;

    private String company;

    private String title;

    private String phone;

    private String jobTitle;

    private String avatarImage;
}
