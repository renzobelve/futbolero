package repository;

import java.io.Serializable;
import model.Player;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renzobelve
 * 
 * Interfaz repository para Player
 */
public interface PlayerRepository extends CrudRepository<Player, Serializable>{
    
}
