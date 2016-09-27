package repository;

import java.io.Serializable;
import model.Question;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renzobelve
 * 
 * Interfaz repository para Question
 */
public interface QuestionRepository extends CrudRepository<Question, Serializable>{
    
}
