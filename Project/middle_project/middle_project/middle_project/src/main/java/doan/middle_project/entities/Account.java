package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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
	private String fullName;

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

	@OneToMany( mappedBy = "account",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserRole> userRole;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "syllabus_id", referencedColumnName = "syllabus_id")
	private Syllabus syllabusId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id")
	private Curriculum curriculumId;

	public Account(String userName, String password, String email, String fullName) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
	}

	@Column(name = "role", columnDefinition = "longtext")
	private String role;
}
