package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Comment;
import domain.Rendezvous;
import domain.Reply;
import domain.User;

import repositories.CommentRepository;

@Service
@Transactional
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	ActorService actorService;
	public CommentService(){
		super();
	}
	
	public Comment create(){
		Comment res = new Comment();
		final Date d = new Date(System.currentTimeMillis());
		final User u = (User) this.actorService.findByPrincipal();
		final Rendezvous r = new Rendezvous();
		final Collection<Reply> replies = new ArrayList<Reply>();
		res.setMoment(d);
		res.setText("Introduzca texto");
		res.setUser(u);
		res.setRendezvous(r);
		res.setReplies(replies);
		
		return res;
	}
	
	public Comment save(final Comment comment){
		Assert.notNull(comment.getRendezvous());
		Assert.notNull(comment.getUser());
		Assert.notNull(comment.getReplies());
		final Date d = new Date(System.currentTimeMillis());
		comment.setMoment(d);
		Comment res = this.commentRepository.save(comment);
		return res;
	}
	
	public Collection<Comment> findAll() {
		Collection<Comment> res;
		res = this.commentRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public Comment findOne(final int id) {
		Comment comment;
		comment = this.commentRepository.findOne(id);
		Assert.notNull(comment);
		return comment;
	}
	
	public void delete(final Comment comment){
		Assert.notNull(comment);
		Collection<Reply> r= comment.getReplies();
		
		r.remove(comment);
		for (Reply i: r)
			this.replyService.save(i);
		
		this.commentRepository.delete(comment);
	}
	

}
