package ibradi.dev.my_store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "admin_table")
public class Admin {

	@Column(name = "first_name", length = 20)
	@NotEmpty
	@Size(min = 3, message = "firstName must contain atleast 3 characters")
	public String firstName;

	@Column(name = "last_name", length = 20)
	@NotEmpty
	@Size(min = 3, message = "lastName must contain atleast 3 characters")
	public String lastName;

	@Column(name = "email_id", unique = true, length = 30)
	@NotEmpty
	@Email(message = "Email  is not valid!")
	public String adminEmailId;

	@Column(name = "password", length = 20)
	@NotEmpty
	@Size(min = 8, message = "Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String adminPassword;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int adminId;

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", adminEmailId="
				+ adminEmailId + ", adminPassword=" + adminPassword + "+]";
	}


}