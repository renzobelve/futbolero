package service;

import dto.GameDTO;
import dto.PlayerDTO;
import exception.PlayerNullException;
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

    /**
     * @param playerDTO
     * @return playerDTO
     * @throws exception.PlayerNullException
     *
     * Metodo para la recuperacion de un player
     */
    public PlayerDTO findOneById(PlayerDTO playerDTO) throws PlayerNullException {
        // Se busca el player
        Player player = this.playerRepository.findOne(playerDTO.getId());
        // Si el player no existe se lanza una excepcion
        if (player == null) {
            throw new PlayerNullException();
        } else {
            return this.convertToPlayerDTO(player);
        }

    }

    /**
     * @param player
     * @return PlayerDTO
     *
     * Metodo para la creacion de un PlayerDTO a traves de un objeto Player
     */
    public PlayerDTO convertToPlayerDTO(Player player) {
        if (player != null) {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            GameDTO gameDTO = new GameDTO();
            gameDTO.setId(player.getActualGame().getId());
            playerDTO.setActualGame(gameDTO);

            return playerDTO;
        } else {
            return null;
        }
    }

}
