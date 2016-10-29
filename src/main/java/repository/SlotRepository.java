package repository;

import java.io.Serializable;
import model.Slot;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renzobelve
 * 
 * Interfaz repository para Slot
 */
public interface SlotRepository extends CrudRepository<Slot, Serializable>{
    
}
