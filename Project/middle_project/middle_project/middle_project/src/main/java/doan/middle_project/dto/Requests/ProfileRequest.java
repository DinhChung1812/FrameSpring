package doan.middle_project.dto.Requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileRequest {

    private int accountId;

    private String name;

    private String userName;

    private String email;

    private String company;

    private String title;

    private String phone;

    private String job_Title;

    private String role;

    private String avatarImage;

}
