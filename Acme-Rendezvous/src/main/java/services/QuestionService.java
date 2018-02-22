
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.QuestionRepository;
import domain.Question;
import domain.QuestionReponse;
import domain.Rendezvous;
import domain.User;

@Service
@Transactional
public class QuestionService {

	@Autowired
	private QuestionRepository		questionRepository;

	@Autowired
	private RendezvousService		rendezvousService;

	@Autowired
	private UserService				userService;

	@Autowired
	private QuestionReponseService	questionReponseService;

	@Autowired
	private ActorService			actorService;


	public QuestionService() {
		super();
	}

	public Question findOne(final int id) {
		return this.questionRepository.findOne(id);
	}

	public Collection<Question> findAll() {
		return this.questionRepository.findAll();
	}

	public Question create() {
		final Question res = new Question();
		final Collection<QuestionReponse> qr = new ArrayList<QuestionReponse>();
		res.setQuestionreponses(qr);
		final User u = (User) this.actorService.findByPrincipal();
		res.setUser(u);
		return res;
	}

	public Question save(final Question question) {
		assert question != null;
		final Question res = this.questionRepository.save(question);
		this.userService.findOne(question.getUser().getId()).getQuestionCreates().add(question);
		this.rendezvousService.findOne(question.getRendezvous().getId()).getQuestions().add(question);
		return res;
	}

	public void delete(final Question question) {
		assert question != null;

		final User user = this.userService.findOne(question.getUser().getId());
		user.getQuestionCreates().remove(question);
		this.userService.save(user);

		final Rendezvous rendezvous = this.rendezvousService.findOne(question.getUser().getId());
		rendezvous.getQuestions().remove(question);
		this.rendezvousService.save(rendezvous);

		final Collection<QuestionReponse> qr = question.getQuestionreponses();
		for (final QuestionReponse qrr : qr)
			this.questionReponseService.delete(qrr);

		this.questionRepository.delete(question);

	}
}
