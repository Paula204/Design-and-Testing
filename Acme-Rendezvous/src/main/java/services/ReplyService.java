
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ReplyRepository;
import domain.Comment;
import domain.Reply;
import domain.User;

@Service
@Transactional
public class ReplyService {

	@Autowired
	private ReplyRepository	replyRepository;

	@Autowired
	private UserService		userService;

	@Autowired
	private CommentService	commentService;

	@Autowired
	private ActorService	actorService;


	public ReplyService() {
		super();
	}

	public Reply findOne(final int id) {
		return this.replyRepository.findOne(id);
	}

	public Collection<Reply> findAll() {
		return this.replyRepository.findAll();
	}

	public Reply create() {
		final Reply res = new Reply();
		final User u = (User) this.actorService.findByPrincipal();
		res.setUser(u);
		return res;
	}

	public Reply save(final Reply reply) {
		assert reply != null;
		final Reply res = this.replyRepository.save(reply);
		final Collection<Reply> replies = this.userService.findOne(reply.getUser().getId()).getReplies();
		replies.add(reply);
		final Collection<Reply> replies2 = this.commentService.findOne(reply.getComment().getId()).getReplies();
		replies2.add(reply);
		this.userService.findOne(reply.getUser().getId()).setReplies(replies);
		this.commentService.findOne(reply.getComment().getId()).setReplies(replies2);
		return res;

	}

	public void delete(final Reply reply) {
		assert reply != null;
		final User user = reply.getUser();
		user.getReplies().remove(reply);
		this.userService.save(user);
		final Comment comment = reply.getComment();
		comment.getReplies().remove(reply);
		this.commentService.save(comment);

		this.replyRepository.delete(reply);

	}
}
