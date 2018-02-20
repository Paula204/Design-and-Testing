package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Rendezvous extends DomainEntity {
	
	private String name;
	private String description;
	private Date moment;
	private Location location;
	private boolean rsvp;
	private boolean isAdult;
	private Collection<User> users;
	private Collection<Comment> comments;
	private User user;
	private Collection<Announcement> announcement;
	private Rendezvous rendezvous;
	private Collection<Rendezvous> rendezvouses;
	
	
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
	
	@NotNull
	@DateTimeFormat
	@Temporal(TemporalType.TIMESTAMP)
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
	
	@NotNull
	public boolean isAdult() {
		return isAdult;
	}
	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
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
	
	
	@Valid
	@OneToMany(mappedBy="rendezvous")
	@NotNull
	public Collection<Announcement> getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(Collection<Announcement> announcement) {
		this.announcement = announcement;
	}
	
	@OneToMany(mappedBy="rendezvous")
	@Valid
	@NotNull
	public Rendezvous getRendezvous() {
		return rendezvous;
	}
	public void setRendezvous(Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}
	
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	public Collection<Rendezvous> getRendezvouses() {
		return rendezvouses;
	}
	public void setRendezvouses(Collection<Rendezvous> rendezvouses) {
		this.rendezvouses = rendezvouses;
	}

	

}
