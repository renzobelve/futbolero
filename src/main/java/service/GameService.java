package service;

import dto.GameDTO;
import dto.PlayerDTO;
import exception.GameEmptyException;
import exception.GameFullException;
import exception.GameNullException;
import exception.PlayerInGameException;
import exception.PlayerNullException;
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
     * @param playerDTO
     * @return gameDTO
     * @throws exception.GameFullException
     * @throws exception.GameEmptyException
     * @throws exception.PlayerNullException
     * @throws exception.PlayerInGameException
     *
     * Metodo para la creacion de un nuevo juego
     */
    @Transactional
    public GameDTO createGame(GameDTO gameDTO, PlayerDTO playerDTO) throws GameFullException, GameEmptyException, PlayerNullException, PlayerInGameException {
        // Se crea un nuevo juego
        Game game = new Game(gameDTO.getPlayerAmount());
        // Se busca al creador
        Player creator = this.playerRepository.findOne(playerDTO.getId());
        if (creator == null) {
            throw new PlayerNullException();
        }
        // Se agrega el creador al nuevo Juego
        game.addPlayer(creator);
        // Se persiste el nuevo Juego
        this.gameRepository.save(game);

        return this.convertToGameDTO(game);
    }

    /**
     * @param id
     * @return gameDTO
     * @throws exception.GameNullException
     *
     * Metodo para la recuperacion de un juego
     */
    public GameDTO findOneById(Long id) throws GameNullException {
        // Se busca el juego
        Game game = this.gameRepository.findOne(id);
        // Si el juego no existe se lanza una excepcion
        if (game == null) {
            throw new GameNullException();
        } else {
            return this.convertToGameDTO(game);
        }

    }

    /**
     * @param gameDTO
     * @param playerDTO
     * @return gameDTO
     * @throws exception.PlayerNullException
     * @throws exception.GameNullException
     * @throws exception.GameFullException
     * @throws exception.GameEmptyException
     * @throws exception.PlayerInGameException
     * 
     * Metodo para incorporar un jugador a un juego
     */
    @Transactional
    public GameDTO joinGame(GameDTO gameDTO, PlayerDTO playerDTO) throws PlayerNullException, GameNullException, GameFullException, GameEmptyException, PlayerInGameException {
        // Se busca el juego
        Game game = this.gameRepository.findOne(gameDTO.getId());
        if (game == null) {
            throw new GameNullException();
        }
        // Se busca al jugador
        Player player = this.playerRepository.findOne(playerDTO.getId());
        if (player == null) {
            throw new PlayerNullException();
        }
        // Se agrega un jugador al juego
        game.addPlayer(player);
        this.gameRepository.save(game);

        return this.convertToGameDTO(game);
    }

    /**
     * @param game
     * @return GameDTO
     *
     * Metodo para la creacion de un GameDTO a traves de un objeto Game
     */
    public GameDTO convertToGameDTO(Game game) {
        if (game != null) {
            GameDTO gameDTO = new GameDTO();
            gameDTO.setId(game.getId());
            gameDTO.setPlayerAmount(game.getPlayerAmount());
            List<PlayerDTO> players = new ArrayList<>();
            for (Player player : game.getPlayers()) {
                PlayerDTO playerDTO = this.playerService.convertToPlayerDTO(player);
                players.add(playerDTO);
            }
            gameDTO.setPlayers(players);
            PlayerDTO activePlayer = this.playerService.convertToPlayerDTO(game.getActivePlayer());
            gameDTO.setActivePlayer(activePlayer);
            return gameDTO;
        } else {
            return null;
        }
    }
}
