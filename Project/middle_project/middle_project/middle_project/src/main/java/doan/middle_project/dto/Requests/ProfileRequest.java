package doan.middle_project.dto.Requests;

import lombok.Data;

@Data
public class ProfileRequest {

    private int accountId;

    private String name;

    private String userName;

    private String email;

    private String company;

    private String title;

    private String phone;

    private String jobTitle;

    private String role;

    private String avatarImage;

}
