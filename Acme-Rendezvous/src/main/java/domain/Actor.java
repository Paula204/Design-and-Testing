package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity {

	private String		name;
	private String		surname;
	private String		address;
	private String		phone;
	private String		email;

	private UserAccount	userAccount;


	@NotBlank
	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}

	@NotBlank
	public String getSurname() {
		return this.surname;
	}
	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(final String address) {
		this.address = address;
	}

	@Pattern(regexp = "^(\\+[0-9]{1,3}\\ \\([0-9]{1,3}\\)\\ [0-9]{3,9})|([0-9]{3,15})|(\\+[0-9]{1,3}\\ [0-9]{3,15})$")
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(final String phone) {
		this.phone = phone;
	}

	@NotBlank
	@Email
	public String getEmail() {
		return this.email;
	}
	public void setEmail(final String email) {
		this.email = email;
	}

	@Valid
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}
