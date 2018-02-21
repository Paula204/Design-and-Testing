
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.QuestionReponse;

@Repository
public interface QuestionReponseRepository extends JpaRepository<QuestionReponse, Integer> {

}
