package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Rendezvous extends DomainEntity {
	
	private String name;
	private String description;
	private Date moment;
	private Location location;
	private boolean rsvp;
	private Collection<User> users;
	private Collection<Comment> comments;
	private User user;
	//private Picture picture;
	
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	@Valid
	@NotNull
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@NotNull
	public boolean isRsvp() {
		return rsvp;
	}
	public void setRsvp(boolean rsvp) {
		this.rsvp = rsvp;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy="rendezvous")
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	
	@Valid
	@NotNull
	@OneToMany(mappedBy="rendezvous")
	public Collection<Comment> getComments() {
		return comments;
	}
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	
	
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
