
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

	private Collection<Comment>		comments;
	private Collection<Rendezvous>	rendezvousesCreated;
	private Collection<Rendezvous>	rendezvousAttending;
	private Collection<Question>	questionCreates;
	private Collection<Question>	quiestionReponses;


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
	public Collection<Question> getQuestionCreates() {
		return this.questionCreates;
	}
	public void setQuestionCreates(final Collection<Question> questionCreates) {
		this.questionCreates = questionCreates;
	}
	public Collection<Question> getQuiestionReponses() {
		return this.quiestionReponses;
	}
	public void setQuiestionReponses(final Collection<Question> quiestionReponses) {
		this.quiestionReponses = quiestionReponses;
	}

}
