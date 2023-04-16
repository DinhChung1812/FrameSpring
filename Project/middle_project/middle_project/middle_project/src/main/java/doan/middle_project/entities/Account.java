package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

	@Column(name = "fullname", columnDefinition = "longtext")
	private String fullname;

	@Column(name = "job_title", columnDefinition = "longtext")
	private String jobTitle;

	@Column(name = "title", columnDefinition = "longtext")
	private String title;

	@Column(name = "email", columnDefinition = "longtext")
	private String email;

	@Column(name = "phone", columnDefinition = "longtext")
	private String phone;

	@Column(name = "avatarImage", columnDefinition = "longtext")
	private String avatarImage;

	@Column(name = "company", columnDefinition = "longtext")
	private String company;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "syllabus_id", referencedColumnName = "syllabus_id")
	private Syllabus syllabusId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id")
	private Curriculum curriculumId;

//	public Account(String userName, String password, String email, String fullName) {
//		this.userName = userName;
//		this.password = password;
//		this.email = email;
//		this.fullname = fullName;
//	}

	public Account(String userName, String password, String fullname, String email, List<UserRole> roleId) {
		this.userName = userName;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.roleId = roleId;
	}

	@Column(name = "role", columnDefinition = "longtext")
	private String role;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Account_UserRole", joinColumns = @JoinColumn(name = "accountId"),
			inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<UserRole> roleId;
}
