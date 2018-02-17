
package domain;

import java.util.Collection;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class User extends Actor {

	private Rendezvous				rendezous;
	private Collection<Rendezvous>	renrezvousCol;
	private Collection<Comment>		comments;


	@NotNull
	@ManyToOne(optional = false)
	public Rendezvous getRendezous() {
		return this.rendezous;
	}
	public void setRendezous(final Rendezvous rendezous) {
		this.rendezous = rendezous;
	}

	//@OneToMany(mappedBy = user)
	public Collection<Rendezvous> getRenrezvousCol() {
		return this.renrezvousCol;
	}
	public void setRenrezvousCol(final Collection<Rendezvous> renrezvousCol) {
		this.renrezvousCol = renrezvousCol;
	}

	//@OneToMany(mappedBy = )
	public Collection<Comment> getComments() {
		return this.comments;
	}
	public void setComments(final Collection<Comment> comments) {
		this.comments = comments;
	}

}
