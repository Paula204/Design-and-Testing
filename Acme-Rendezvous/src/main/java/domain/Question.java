
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Question extends DomainEntity {

	private String				title;
	private String				description;
	private User				creator;
	private Collection<User>	users;
	private Rendezvous			rendezvous;

}
