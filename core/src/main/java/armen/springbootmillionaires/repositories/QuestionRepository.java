package armen.springbootmillionaires.repositories;


import armen.springbootmillionaires.DB.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Questions, Integer> {
}
