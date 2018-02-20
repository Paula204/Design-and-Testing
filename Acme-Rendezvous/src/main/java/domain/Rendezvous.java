
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import org.hibernate.validator.constraints.URL;

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
	
	

	private boolean					isPublished;
	private String					picture;

	private Collection<Question>	questions;


	//private Picture picture;

	@NotBlank
	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}

	@NotBlank
	public String getDescription() {
		return this.description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	
	@NotNull
	@DateTimeFormat
	@Temporal(TemporalType.TIMESTAMP)


	public Date getMoment() {
		return this.moment;
	}
	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	@Valid
	@NotNull
	public Location getLocation() {
		return this.location;
	}
	public void setLocation(final Location location) {
		this.location = location;
	}

	@NotNull
	public boolean isRsvp() {
		return this.rsvp;
	}
	public void setRsvp(final boolean rsvp) {
		this.rsvp = rsvp;
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
	@OneToMany(mappedBy = "rendezvous")
	public Collection<Comment> getComments() {
		return this.comments;
	}
	public void setComments(final Collection<Comment> comments) {
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
	@ManyToOne(optional = false)
	public User getUser() {
		return this.user;
	}
	public void setUser(final User user) {
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

	
	@NotNull
	public boolean isPublished() {
		return this.isPublished;
	}
	public void setPublished(final boolean isPublished) {
		this.isPublished = isPublished;
	}

	@URL
	public String getPicture() {
		return this.picture;
	}
	public void setPicture(final String picture) {
		this.picture = picture;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "rendezvous")
	public Collection<Question> getQuestions() {
		return this.questions;
	}
	public void setQuestions(final Collection<Question> questions) {
		this.questions = questions;
	}

}
