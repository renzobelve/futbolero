package service;

import dto.GameDTO;
import dto.PlayerDTO;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlayerRepository;

/**
 *
 * @author renzobelve
 * 
 * Clase de servicio para funcionalidades de Game
 */
@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerDTO convertToPlayerDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(player.getActualGame().getId());
        playerDTO.setActualGame(gameDTO);
        
        return playerDTO;
    }
    
}
