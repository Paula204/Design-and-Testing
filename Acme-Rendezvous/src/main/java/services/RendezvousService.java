
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.RendezvousRepository;
import domain.Announcement;
import domain.Comment;
import domain.Question;
import domain.Rendezvous;
import domain.User;

@Service
@Transactional
public class RendezvousService {

	@Autowired
	private RendezvousRepository	rendezvousRepository;

	@Autowired
	private UserService				userService;

	@Autowired
	private QuestionService			questionService;

	@Autowired
	private CommentService			commentService;

	@Autowired
	private AnnouncementService		announcementService;

	@Autowired
	private ActorService			actorService;


	public RendezvousService() {
		super();
	}

	public Rendezvous findOne(final int id) {
		return this.rendezvousRepository.findOne(id);
	}

	public Collection<Rendezvous> findAll() {
		return this.rendezvousRepository.findAll();
	}

	public Rendezvous create() {
		final Rendezvous res = new Rendezvous();
		final User u = (User) this.actorService.findByPrincipal();
		res.setUser(u);
		final Collection<User> users = new ArrayList<User>();
		users.add(u);
		res.setUsers(users);
		final Collection<Question> q = new ArrayList<Question>();
		res.setQuestions(q);
		final Collection<Announcement> a = new ArrayList<Announcement>();
		res.setAnnouncements(a);
		final Collection<Comment> c = new ArrayList<Comment>();
		res.setComments(c);
		final Collection<Rendezvous> re = new ArrayList<Rendezvous>();
		res.setRendezvouses(re);
		res.setPublished(false);

		return res;
	}

	public Rendezvous save(final Rendezvous rendezvous) {
		assert rendezvous != null;
		final Rendezvous res = this.rendezvousRepository.save(rendezvous);
		final User u = this.userService.findOne(rendezvous.getId());
		final Collection<Rendezvous> re = u.getRendezvousesCreated();
		re.add(rendezvous);
		this.userService.findOne(rendezvous.getId()).setRendezvousesCreated(re);
		final Collection<Rendezvous> r = u.getRendezvousAttending();
		r.add(rendezvous);
		this.userService.findOne(rendezvous.getId()).setRendezvousAttending(r);

		return res;

	}

	public void delete(final Rendezvous rendezvous) {
		if (rendezvous.isPublished() == false) {
			assert rendezvous != null;
			final User u = this.userService.findOne(rendezvous.getId());
			u.getRendezvousesCreated().remove(rendezvous);
			u.getRendezvousAttending().remove(rendezvous);
			this.userService.save(u);

			final Collection<User> users = rendezvous.getUsers();
			for (final User uee : users)
				this.userService.findOne(uee.getId()).getRendezvousAttending().remove(rendezvous);

			final Collection<Question> qs = rendezvous.getQuestions();
			for (final Question q : qs)
				this.questionService.delete(q);

			final Collection<Announcement> an = rendezvous.getAnnouncements();
			for (final Announcement a : an)
				this.announcementService.delete(a);

			final Collection<Comment> cs = rendezvous.getComments();
			for (final Comment c : cs)
				this.commentService.delete(c);

			this.rendezvousRepository.delete(rendezvous);

		} else {
			assert rendezvous != null;
			final User u = this.userService.findOne(rendezvous.getId());
			u.getRendezvousesCreated().remove(rendezvous);
			u.getRendezvousAttending().remove(rendezvous);
			this.userService.save(u);

			final Collection<User> users = rendezvous.getUsers();
			for (final User uee : users)
				this.userService.findOne(uee.getId()).getRendezvousAttending().remove(rendezvous);

			final Collection<Question> qs = rendezvous.getQuestions();
			for (final Question q : qs)
				this.questionService.delete(q);

			final Collection<Announcement> an = rendezvous.getAnnouncements();
			for (final Announcement a : an)
				this.announcementService.delete(a);

			final Collection<Comment> cs = rendezvous.getComments();
			for (final Comment c : cs)
				this.commentService.delete(c);

			rendezvous.setPublished(false);
			this.rendezvousRepository.save(rendezvous);

		}
	}

}
