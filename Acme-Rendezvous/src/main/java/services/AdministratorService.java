package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Administrator;

import repositories.AdministratorRepository;
import security.Authority;
import security.UserAccount;

@Service
@Transactional
public class AdministratorService {
	
	@Autowired
	AdministratorRepository administratorRepository;
	@Autowired
	ActorService actorService;
	
	public AdministratorService(){
		super();
	}
	
	public Administrator create(){
		Administrator res= new Administrator();
		return res;
	}
	
	public Administrator save(Administrator admin){
		Assert.notNull(admin);
		Assert.notNull(admin.getEmail());
		Assert.notNull(admin.getName());
		Assert.notNull(admin.getSurname());
		Assert.notNull(admin.getUserAccount());
		
		Administrator res= this.administratorRepository.save(admin);
		return res;
		
	}
	
	
	public Administrator saveWithUserAccount(final Administrator admin) {
		Assert.notNull(admin);
		Assert.notNull(admin.getEmail());
		Assert.notNull(admin.getName());
		Assert.notNull(admin.getSurname());

		final Md5PasswordEncoder coder = new Md5PasswordEncoder();
		final String pass = coder.encodePassword(admin.getUserAccount().getPassword(), null);
		final UserAccount user = new UserAccount();

		user.setId(admin.getUserAccount().getId());
		user.setVersion(admin.getUserAccount().getVersion());
		user.setUsername(admin.getUserAccount().getUsername());
		user.setPassword(pass);

		final Collection<Authority> auth = new ArrayList<Authority>();
		final Authority autho = new Authority();
		autho.setAuthority(Authority.ADMIN);
		auth.add(autho);
		user.setAuthorities(auth);

		admin.setUserAccount(user);

		return this.administratorRepository.save(admin);
	}
	
	public void delete(final Administrator admin) {
		Assert.notNull(admin);
		this.administratorRepository.delete(admin);
	}

}
