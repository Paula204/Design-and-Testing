
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class QuestionReponse extends DomainEntity {

	private User		user;
	private Question	question;
	private String		text;


	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public User getUser() {
		return this.user;
	}
	public void setUser(final User user) {
		this.user = user;
	}

	@NotBlank
	public String getText() {
		return this.text;
	}
	public void setText(final String text) {
		this.text = text;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Question getQuestion() {
		return this.question;
	}
	public void setQuestion(final Question question) {
		this.question = question;
	}

}
