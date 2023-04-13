package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Integer accountId;

	@Column(name = "username", columnDefinition = "longtext")
	private String userName;

	@Column(name = "password", columnDefinition = "longtext")
	private String password;

	@Column(name = "role", columnDefinition = "longtext")
	private String role;

	@Column(name = "name", columnDefinition = "longtext")
	private String name;

	@Column(name = "address", columnDefinition = "longtext")
	private String address;

	@Column(name = "gender", columnDefinition = "longtext")
	private String gender;

	@Column(name = "email", columnDefinition = "longtext")
	private String email;

	@Column(name = "phone", columnDefinition = "longtext")
	private String phone;

	@Column(name = "avatarImage", columnDefinition = "longtext")
	private String avatarImage;

	@Column(name = "dob", columnDefinition = "DATE")
	private LocalDate dob;

	@Column(nullable=true, name = "high")
	private Double high;

	@Column(nullable=true, name = "weight")
	private Double weight;

	@Column(nullable=true, name = "mobility")
	private Double mobility;

	@Column(nullable=true, name = "totalCalo")
	private Double totalCalo;

	@Column(name = "target", columnDefinition = "longtext")
	private String target;

	@Column(name = "targetIndex")
	private Double targetIndex;

	@Column(name = "create_date", columnDefinition = "DATE")
	private LocalDate createDate;

	@Column(name = "update_date", columnDefinition = "DATE")
	private LocalDate updateDate;

	@Column(name = "status")
	private Integer status;

	@Column(name = "reset_password_token", columnDefinition = "longtext")
	private String resetPasswordToken;

	public Account(String userName, String password, String email, String name) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
	}
}
