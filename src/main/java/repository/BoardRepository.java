package repository;

import java.io.Serializable;
import model.Board;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renzobelve
 * 
 * Interfaz repository para Board
 */
public interface BoardRepository extends CrudRepository<Board, Serializable>{
    
}
