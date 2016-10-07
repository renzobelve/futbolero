package repository;

import java.io.Serializable;
import java.util.List;
import model.Game;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renzobelve
 * 
 * Interfaz repository para Game
 */
public interface GameRepository extends CrudRepository<Game, Serializable>{
    
    public List<Game> findByIsOpen(boolean isOpen);
    
}
