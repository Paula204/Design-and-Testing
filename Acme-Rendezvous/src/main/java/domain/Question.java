
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Question extends DomainEntity {

	private String				title;
	private String				description;
	private User				creator;
	private Collection<User>	users;
	private Rendezvous			rendezvous;


	@NotBlank
	public String getTitle() {
		return this.title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}

	@NotBlank
	public String getDescription() {
		return this.description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public User getCreator() {
		return this.creator;
	}
	public void setCreator(final User creator) {
		this.creator = creator;
	}

	@Valid
	@NotNull
	@ManyToMany
	public Collection<User> getUsers() {
		return this.users;
	}
	public void setUsers(final Collection<User> users) {
		this.users = users;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Rendezvous getRendezvous() {
		return this.rendezvous;
	}
	public void setRendezvous(final Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}

}
