
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.UserRepository;
import security.Authority;
import security.UserAccount;
import domain.Announcement;
import domain.Comment;
import domain.Question;
import domain.QuestionReponse;
import domain.Rendezvous;
import domain.Reply;
import domain.User;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository			userRepository;
	@Autowired
	AnnouncementService		announcementService;
	@Autowired
	CommentService			commentService;
	@Autowired
	ReplyService			replyService;
	@Autowired
	QuestionService			questionService;
	@Autowired
	RendezvousService		rendezvousService;
	@Autowired
	QuestionReponseService	questionReponseService;


	public UserService() {
		super();
	}

	public User create() {
		final User res = new User();
		res.setComments(new ArrayList<Comment>());
		res.setRendezvousesCreated(new ArrayList<Rendezvous>());
		res.setRendezvousAttending(new ArrayList<Rendezvous>());
		res.setAnnouncements(new ArrayList<Announcement>());
		res.setQuestionCreates(new ArrayList<Question>());
		res.setQuestionReponses(new ArrayList<QuestionReponse>());
		res.setReplies(new ArrayList<Reply>());
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

	public User save(final User u) {
		Assert.notNull(u);
		Assert.notNull(u.getComments());
		Assert.notNull(u.getRendezvousesCreated());
		Assert.notNull(u.getAnnouncements());
		Assert.notNull(u.getUserAccount());
		Assert.notNull(u.getName());
		Assert.notNull(u.getSurname());
		Assert.notNull(u.getEmail());
		Assert.notNull(u.getQuestionCreates());
		Assert.notNull(u.getQuestionReponses());
		Assert.notNull(u.getReplies());
		Assert.notNull(u.getRendezvousAttending());
		final User res = this.userRepository.save(u);
		return res;
	}

	public User saveWithUserAccount(final User u) {
		Assert.notNull(u);
		Assert.notNull(u.getComments());
		Assert.notNull(u.getRendezvousesCreated());
		Assert.notNull(u.getAnnouncements());
		Assert.notNull(u.getUserAccount());
		Assert.notNull(u.getName());
		Assert.notNull(u.getSurname());
		Assert.notNull(u.getEmail());
		Assert.notNull(u.getQuestionCreates());
		Assert.notNull(u.getQuestionReponses());
		Assert.notNull(u.getReplies());
		Assert.notNull(u.getRendezvousAttending());

		final Md5PasswordEncoder coder = new Md5PasswordEncoder();

		final String pass = coder.encodePassword(u.getUserAccount().getPassword(), null);

		final UserAccount user = new UserAccount();

		user.setId(u.getUserAccount().getId());
		user.setVersion(u.getUserAccount().getVersion());
		user.setUsername(u.getUserAccount().getUsername());
		user.setPassword(pass);

		final Collection<Authority> auth = new ArrayList<Authority>();
		final Authority authh = new Authority();
		authh.setAuthority(Authority.USER);
		auth.add(authh);
		user.setAuthorities(auth);

		u.setUserAccount(user);

		return this.userRepository.save(u);
	}

	public void delete(final User user) {
		Assert.notNull(user);
		final Collection<Announcement> announ = user.getAnnouncements();
		final Collection<Reply> rep = user.getReplies();
		final Collection<QuestionReponse> qr = user.getQuestionReponses();
		final Collection<Question> q = user.getQuestionCreates();
		final Collection<Comment> comm = user.getComments();
		final Collection<Rendezvous> renA = user.getRendezvousAttending();
		final Collection<Rendezvous> rendC = user.getRendezvousesCreated();

		announ.remove(user);
		rep.remove(user);
		qr.remove(user);
		q.remove(user);
		comm.remove(user);
		renA.remove(user);
		rendC.remove(user);

		for (final Announcement i : announ)
			this.announcementService.save(i);
		for (final Reply j : rep)
			this.replyService.save(j);
		for (final QuestionReponse k : qr)
			this.questionReponseService.save(k);
		for (final Question l : q)
			this.questionService.save(l);
		for (final Comment m : comm)
			this.commentService.save(m);
		for (final Rendezvous n : renA)
			this.rendezvousService.save(n);
		for (final Rendezvous o : rendC)
			this.rendezvousService.save(o);

		this.userRepository.delete(user);
	}

}
