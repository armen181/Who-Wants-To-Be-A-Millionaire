package armen.springbootmillionaires.repositories;


import armen.springbootmillionaires.DB.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Questions, Integer> {
}
