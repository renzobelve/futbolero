package service;

import dto.SlotDTO;
import model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BoardRepository;
import repository.SlotRepository;

/**
 *
 * @author renzobelve
 *
 * Clase de servicio para funcionalidades de Game
 */
@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    
    @Autowired
    private SlotRepository slotRepository;

    /**
     * @param slot
     * @return SlotDTO
     *
     * Metodo para la creacion de un SlotDTO a traves de un objeto Slot
     */
    public SlotDTO convertToSlotDTO(Slot slot) {
        //TO-DO
        return null;
    }
    
}
