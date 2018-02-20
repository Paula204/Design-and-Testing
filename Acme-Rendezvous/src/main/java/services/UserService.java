package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Announcement;
import domain.Comment;
import domain.Rendezvous;
import domain.User;

import repositories.RendezvousRepository;
import repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserService() {
		super();
	}
	
	public User create(){
		final User res = new User();
		res.setComments(new ArrayList<Comment>());
		res.setRendezvouses(new ArrayList<Rendezvous>());
		res.setAnnouncements(new ArrayList<Announcement>());
		return res;
	}
	
	public Collection<User> findAll() {
		Collection<User> res;
		res = this.userRepository.findAll();
		Assert.notNull(res);
		return res;
	}
	

	public User findOne(final int id) {
		Assert.isTrue(id != 0);
		User res;
		res = this.userRepository.findOne(id);
		Assert.notNull(res);
		return res;
	}
	
	public User save(final User u){
		Assert.notNull(u);
		Assert.notNull(u.getComments());
		Assert.notNull(u.getRendezvous());
		Assert.notNull(u.getAnnouncements());
		Assert.notNull(u.getUserAccount());
		Assert.notNull(u.getName());
		Assert.notNull(u.getSurname());
		Assert.notNull(u.getEmail());
		 User res=this.userRepository.save(u);
		return res;
	}

}
