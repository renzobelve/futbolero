package repository;

import java.io.Serializable;
import model.SituationCard;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renzobelve
 * 
 * Interfaz repository para SituationCard
 */
public interface SituationCardRepository extends CrudRepository<SituationCard, Serializable>{
    
}
