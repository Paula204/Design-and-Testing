
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class User extends Actor {

	private Collection<Comment>			comments;
	private Collection<Rendezvous>		rendezvousesCreated;
	private Collection<Rendezvous>		rendezvousAttending;
	private Collection<Question>		questionCreates;
	private Collection<QuestionReponse>	questionReponses;
	private Collection<Reply>			replies;
	private Collection<Announcement>	announcements;


	@Valid
	@OneToMany(mappedBy = "user")
	@NotNull
	public Collection<Comment> getComments() {
		return this.comments;
	}
	public void setComments(final Collection<Comment> comments) {
		this.comments = comments;
	}

	@Valid
	@OneToMany(mappedBy = "user")
	@NotNull
	public Collection<Rendezvous> getRendezvousesCreated() {
		return this.rendezvousesCreated;
	}
	public void setRendezvousesCreated(final Collection<Rendezvous> rendezvousesCreated) {
		this.rendezvousesCreated = rendezvousesCreated;
	}

	@Valid
	@NotNull
	@ManyToMany
	public Collection<Rendezvous> getRendezvousAttending() {
		return this.rendezvousAttending;
	}
	public void setRendezvousAttending(final Collection<Rendezvous> rendezvousAttending) {
		this.rendezvousAttending = rendezvousAttending;
	}

	@Valid
	@OneToMany(mappedBy = "user")
	@NotNull
	public Collection<Question> getQuestionCreates() {
		return this.questionCreates;
	}
	public void setQuestionCreates(final Collection<Question> questionCreates) {
		this.questionCreates = questionCreates;
	}

	@Valid
	@OneToMany(mappedBy = "user")
	@NotNull
	public Collection<Reply> getReplies() {
		return this.replies;
	}
	public void setReplies(final Collection<Reply> replies) {
		this.replies = replies;
	}

	@Valid
	@OneToMany(mappedBy = "user")
	@NotNull
	public Collection<QuestionReponse> getQuiestionReponses() {
		return this.questionReponses;
	}
	public void setQuiestionReponses(final Collection<QuestionReponse> quiestionReponses) {
		this.questionReponses = quiestionReponses;
	}

	@OneToMany(mappedBy = "user")
	@Valid
	@NotNull
	public Collection<Announcement> getAnnouncements() {
		return this.announcements;
	}
	public void setAnnouncements(final Collection<Announcement> announcements) {
		this.announcements = announcements;
	}

}
