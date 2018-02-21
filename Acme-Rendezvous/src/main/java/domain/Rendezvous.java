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
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Rendezvous extends DomainEntity {

	private String						title;
	private String						description;
	private Date						moment;
	private Location					location;
	private boolean						rsvp;
	private boolean						isAdult;
	private boolean						isPublished;
	private User						user;
	private Rendezvous					rendezvous;
	private String						picture;
	private Collection<Announcement>	announcements;
	private Collection<Rendezvous>		rendezvouses;
	private Collection<User>			users;
	private Collection<Comment>			comments;
	private Collection<Question>		questions;


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
	public boolean getIsAdult() {
		return this.isAdult;
	}
	public void setIsAdult(final boolean isAdult) {
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
	@OneToMany(mappedBy = "rendezvous")
	@NotNull
	public Collection<Announcement> getAnnouncements() {
		return this.announcements;
	}
	public void setAnnouncements(final Collection<Announcement> announcement) {
		this.announcements = announcement;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "rendezvous")
	public Collection<Rendezvous> getRendezvouses() {
		return this.rendezvouses;
	}
	public void setRendezvouses(final Collection<Rendezvous> rendezvouses) {
		this.rendezvouses = rendezvouses;
	}

	@NotNull
	public boolean getIsPublished() {
		return this.isPublished;
	}
	public void setIsPublished(final boolean isPublished) {
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