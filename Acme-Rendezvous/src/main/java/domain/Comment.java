
package domain;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class Comment extends DomainEntity {

	private Date		moment;
	private String		text;
	private String		picture;

	private Rendezvous	rendezvous;
	private User		user;


	@NotNull
	public Date getMoment() {
		return this.moment;
	}
	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	@NotBlank
	public String getText() {
		return this.text;
	}
	public void setText(final String text) {
		this.text = text;
	}

	@URL
	public String getPicture() {
		return this.picture;
	}
	public void setPicture(final String picture) {
		this.picture = picture;
	}

	@ManyToOne(optional = false)
	public Rendezvous getRendezvous() {
		return this.rendezvous;
	}
	public void setRendezvous(final Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}

	@ManyToOne(optional = false)
	public User getUser() {
		return this.user;
	}
	public void setUser(final User user) {
		this.user = user;
	}
}
