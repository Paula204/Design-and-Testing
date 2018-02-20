package services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.AnnouncementRepository;

import domain.Announcement;
import domain.User;

@Service
@Transactional
public class AnnouncementService {

	@Autowired
	AnnouncementRepository announcementRepository;
	@Autowired
	ActorService actorService;
	
	public AnnouncementService(){
		super();
	}
	
	public Announcement create(){
		Announcement res = new Announcement();
		final Date d = new Date(System.currentTimeMillis() - 5);
		final User u = (User) this.actorService.findByPrincipal();
		res.setTitle("Inserte un título");
		res.setDescription("Inserte texto");
		res.setUser(u);
		return res;
	}
	
	public void save(Announcement i) {
		// TODO Auto-generated method stub
		
	}

}
