package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import domain.Actor;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class ActorService {

	private ActorRepository		actorRepository;

	
	public ActorService() {
		super();
	}
	
	public Actor findOne(final int id){
		return this.actorRepository.findOne(id);
	}
	
	//Encontrar un actor por su id
	public Actor findByUserAccointId(final int id) {
		return this.actorRepository.findByUserAccountId(id);
	}
	
	//Encontrar el actor logeado en el sistema
	public Actor findByPrincipal() {
		final UserAccount userAccount = LoginService.getPrincipal();
		return this.actorRepository.findByUserAccountId(userAccount.getId());
	}
	
	public Collection<Actor> findAll() {
		return this.actorRepository.findAll();
	}

	public Actor save(final Actor actor) {

		assert actor != null;
		return this.actorRepository.save(actor);
	}

	public Collection<Actor> saveAll(final Collection<Actor> actors) {
		assert actors != null;

		return this.actorRepository.save(actors);
	}
	
}
