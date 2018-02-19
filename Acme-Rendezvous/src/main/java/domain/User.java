package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class User extends Actor{
	
	private Collection<Comment> comments;
	private Collection<Rendezvous> rendezvouses;
	private Rendezvous rendezvous;
	private Collection<Announcement> announcements;
	
	
	@Valid
	@OneToMany(mappedBy="user")
	@NotNull
	public Collection<Comment> getComments() {
		return comments;
	}
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	
	@Valid
	@OneToMany(mappedBy="user")
	@NotNull	
	public Collection<Rendezvous> getRendezvouses() {
		return rendezvouses;
	}
	public void setRendezvouses(Collection<Rendezvous> rendezvouses) {
		this.rendezvouses = rendezvouses;
	}
	
	@ManyToOne(optional=false)
	public Rendezvous getRendezvous() {
		return rendezvous;
	}
	public void setRendezvous(Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}
	
	@OneToMany(mappedBy="user")
	@Valid
	@NotNull
	public Collection<Announcement> getAnnouncements() {
		return announcements;
	}
	public void setAnnouncements(Collection<Announcement> announcements) {
		this.announcements = announcements;
	}

}
