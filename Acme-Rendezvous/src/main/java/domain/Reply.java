
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Reply extends DomainEntity {

	private String	text;
	private Date	moment;

	private User	user;
	private Comment	comment;


	@NotBlank
	public String getText() {
		return this.text;
	}
	public void setText(final String text) {
		this.text = text;
	}

	@NotNull
	public Date getMoment() {
		return this.moment;
	}
	public void setMoment(final Date moment) {
		this.moment = moment;
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
	@NotNull
	@ManyToOne(optional = false)
	public Comment getComment() {
		return this.comment;
	}
	public void setComment(final Comment comment) {
		this.comment = comment;
	}

}
