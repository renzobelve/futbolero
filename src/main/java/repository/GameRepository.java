package repository;

import java.io.Serializable;
import model.Game;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renzobelve
 * 
 * Interfaz repository para Game
 */
public interface GameRepository extends CrudRepository<Game, Serializable>{
    
}
