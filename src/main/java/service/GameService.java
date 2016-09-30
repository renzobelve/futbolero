package service;

import dto.GameDTO;
import dto.PlayerDTO;
import exception.GameEmptyException;
import exception.GameFullException;
import exception.GameNullException;
import java.util.ArrayList;
import java.util.List;
import model.Game;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.GameRepository;
import repository.PlayerRepository;

/**
 *
 * @author renzobelve
 *
 * Clase de servicio para funcionalidades de Game
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private PlayerService playerService;

    /**
     * @param gameDTO
     * @return gameDTO
     * @throws exception.GameFullException
     * @throws exception.GameEmptyException
     * 
     * Metodo para la creacion de un nuevo Juego
     */
    @Transactional
    public GameDTO createGame(GameDTO gameDTO) throws GameFullException, GameEmptyException {
        // Se crea un nuevo juego
        Game game = new Game(gameDTO.getPlayerAmount());
        // Se busca al creador
        Player creator = this.playerRepository.findOne(gameDTO.getCreator().getId());
        // Se agrega el creador al nuevo Juego
        game.addPlayer(creator);
        // Se persiste el nuevo Juego
        this.gameRepository.save(game);
        
        return this.convertToGameDTO(game);
    }
    
    /**
     * @param gameDTO
     * @return gameDTO
     * @throws exception.GameNullException
     * 
     * Metodo para la recuperacion de un juego
     */
    public GameDTO findOneById(GameDTO gameDTO) throws GameNullException{
        // Se busca el juego
        Game game = this.gameRepository.findOne(gameDTO.getId());
        // Si el juego no existe se lanza una excepcion
        if(game == null){
            throw new GameNullException();
        }else{
            return this.convertToGameDTO(game);
        }
    
    }

    /**
     * 
     * Metodo para la creacion de un GameDTO a traves de un objeto Game
     */
    private GameDTO convertToGameDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setPlayerAmount(game.getPlayerAmount());
        List<PlayerDTO> players = new ArrayList<>();
        for(Player player : game.getPlayers()){
            PlayerDTO playerDTO = this.playerService.convertToPlayerDTO(player);
            players.add(playerDTO);
        }
        gameDTO.setPlayers(players);
        return gameDTO;
    }
}
