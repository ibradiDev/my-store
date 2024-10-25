package ibradi.dev.my_store.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "customer_table")
@SequenceGenerator(name = "generator1", sequenceName = "gen1", initialValue = 1000)
public class Customer {
	@Column(name = "email_id", unique = true, length = 30)
	@NotEmpty
	@Email(message = "Email  is not valid!")
	public String emailID;

	@Column(name = "gender", length = 30)
	@NotEmpty
	@Size(min = 4, message = "gender must contain atleast 4 characters")
	public String gender;

	@Column(name = "password", length = 20)
	@NotEmpty
	@Size(min = 8, message = "Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String password;

	@Column(name = "address")
	@NotEmpty
	public String address;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "first_name", length = 20)
	@NotEmpty
	@Size(min = 3, message = "firstName must contain atleast 3 characters")
	private String firstName;

	@Column(name = "last_name", length = 20)
	@NotEmpty
	@Size(min = 3, message = "lastName must contain atleast 3 characters")
	private String lastName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "phone_number")
	@NotEmpty
	@Size(min = 10, max = 10, message = "phoneNumber must contain  10 digits")
	private String phoneNumber;

	@Column(name = "district", length = 20)
	@NotEmpty
	@Size(min = 3, message = "district must contain atleast 3 characters")
	private String district;

	@Column(name = "state", length = 20)
	@NotEmpty
	@Size(min = 3, message = "district must contain atleast 3 characters")
	private String state;

	@Column(name = "zip_code")
	@NotEmpty
	@Size(min = 6, max = 6, message = "zipCode must contain 6 digits")
	private String zipCode;


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", district=" + district + ", state=" + state + ", zipCode=" + zipCode + ", emailID=" + emailID + ", gender=" + gender + ", password=" + password + "]";
	}


}