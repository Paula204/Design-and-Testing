package services;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.AnnouncementRepository;

import domain.Announcement;
import domain.Comment;
import domain.Rendezvous;
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
	
	public Announcement save(final Announcement a) {

		Assert.notNull(a);
		Assert.notNull(a.getTitle());
		Assert.notNull(a.getDescription());
		Assert.notNull(a.getUser());
		Assert.notNull(a.getRendezvous());
		Date d = new Date(System.currentTimeMillis()-5);
		a.setMoment(d);
		Announcement res = this.announcementRepository.save(a);
		return res;
		
	}
	
	public Collection<Announcement> findAll() {
		Collection<Announcement> res;
		res = this.announcementRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public Announcement findOne(final int id) {
		Announcement announcement;
		announcement = this.announcementRepository.findOne(id);
		Assert.notNull(announcement);
		return announcement;
	}
	
	public void delete(final Announcement ann){
		Assert.notNull(ann);
		Rendezvous r =ann.getRendezvous();
		//r.getAnnouncements().remove(ann);
		//Y el for guardando eso
		this.announcementRepository.delete(ann);
	}
}
