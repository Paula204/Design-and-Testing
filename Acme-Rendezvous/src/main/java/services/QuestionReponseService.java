
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.QuestionReponseRepository;
import domain.Question;
import domain.QuestionReponse;
import domain.User;

@Service
@Transactional
public class QuestionReponseService {

	@Autowired
	private QuestionReponseRepository	questionReponseRepository;

	@Autowired
	private QuestionService				questionService;

	@Autowired
	private UserService					userService;

	@Autowired
	private ActorService				actorService;


	public QuestionReponseService() {
		super();
	}

	public QuestionReponse findOne(final int id) {
		return this.questionReponseRepository.findOne(id);
	}

	public Collection<QuestionReponse> findAll() {
		return this.questionReponseRepository.findAll();
	}

	public QuestionReponse create() {
		final QuestionReponse res = new QuestionReponse();
		final User u = (User) this.actorService.findByPrincipal();
		res.setUser(u);
		return res;
	}

	public QuestionReponse save(final QuestionReponse questionReponse) {
		assert questionReponse != null;
		final QuestionReponse res = this.questionReponseRepository.save(questionReponse);

		this.questionService.findOne(questionReponse.getQuestion().getId()).getQuestionreponses().add(questionReponse);
		this.userService.findOne(questionReponse.getUser().getId()).getQuestionReponses().add(questionReponse);

		return res;
	}

	public void delete(final QuestionReponse questionReponse) {
		assert questionReponse != null;

		final Question q = questionReponse.getQuestion();
		q.getQuestionreponses().remove(questionReponse);
		this.questionService.save(q);

		final User u = questionReponse.getUser();
		u.getQuestionReponses().remove(questionReponse);
		this.userService.save(u);

		this.questionReponseRepository.delete(questionReponse);

	}

}
