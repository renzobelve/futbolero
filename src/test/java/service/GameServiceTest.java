package service;

import app.Application;
import dto.GameDTO;
import dto.PlayerDTO;
import exception.GameEmptyException;
import exception.GameFullException;
import exception.GameNotFinishedException;
import exception.GameNullException;
import exception.PlayerInGameException;
import exception.PlayerNotInGameException;
import exception.PlayerNullException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author renzobelve
 *
 * Clase que testea actividades y funcionamiento de GameService
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class GameServiceTest {

    @Autowired
    private GameService gameService;
    
    @Autowired
    private PlayerService playerService;

    @Test
    public void testCreateRemoveJoinStartGame() {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setPlayerAmount(4);
        // Creador
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId((long) 55);
        // Jugadores
        PlayerDTO playerDTO2 = new PlayerDTO();
        playerDTO2.setId((long) 57);
        PlayerDTO playerDTO3 = new PlayerDTO();
        playerDTO3.setId((long) 59);
        PlayerDTO playerDTO4 = new PlayerDTO();
        playerDTO4.setId((long) 61);
        try {
            // Test create
            GameDTO newGame = this.gameService.createGame(gameDTO, playerDTO);
            Assert.assertNotNull(newGame.getId());
            Assert.assertEquals(1, newGame.getPlayers().size());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(0).getActualGame().getId());
            Assert.assertTrue(newGame.isIsOpen());
            // Test join
            this.gameService.joinGame(newGame, playerDTO2);
            newGame = this.gameService.findOneById((long) newGame.getId());
            Assert.assertNotNull(newGame.getId());
            Assert.assertEquals(2, newGame.getPlayers().size());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(0).getActualGame().getId());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(1).getActualGame().getId());
            // Test remove
            playerDTO2 = this.playerService.findOneById((long) playerDTO2.getId());
            newGame = this.gameService.findOneById((long) newGame.getId());
            this.gameService.removePlayer(newGame, playerDTO2);
            playerDTO2 = this.playerService.findOneById((long) playerDTO2.getId());
            newGame = this.gameService.findOneById((long) newGame.getId());
            Assert.assertNull(playerDTO2.getActualGame());
            Assert.assertEquals(1, newGame.getPlayers().size());
            // Test start
            this.gameService.joinGame(newGame, playerDTO2);
            this.gameService.joinGame(newGame, playerDTO3);
            this.gameService.joinGame(newGame, playerDTO4);
            newGame = this.gameService.findOneById((long) newGame.getId());
            Assert.assertNotNull(newGame.getId());
            Assert.assertEquals(4, newGame.getPlayers().size());
            Assert.assertFalse(newGame.isIsOpen());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(0).getActualGame().getId());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(1).getActualGame().getId());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(2).getActualGame().getId());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(3).getActualGame().getId());
            Assert.assertNotNull(newGame.getActivePlayer());
        } catch (GameFullException | GameEmptyException | PlayerNullException | GameNullException | PlayerInGameException | GameNotFinishedException | PlayerNotInGameException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testFindGame() {
        try {
            GameDTO retrievedGame = this.gameService.findOneById((long) 1);
            Assert.assertNotNull(retrievedGame.getId());
        } catch (GameNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testNextPlayerTurn() {
        try {
            // Setup game
            GameDTO gameDTO = this.gameService.findOneById((long) 1);
            PlayerDTO playerDTO1 = this.playerService.findOneById((long) 63);
            PlayerDTO playerDTO2 = this.playerService.findOneById((long) 65);
            this.gameService.joinGame(gameDTO, playerDTO1);
            this.gameService.joinGame(gameDTO, playerDTO2);
            GameDTO startedGame = this.gameService.findOneById((long) 1);
            Assert.assertNull(startedGame.getWinner());
            Assert.assertEquals(2, startedGame.getPlayers().size());
            // Next Player
            PlayerDTO playerTurn1 = startedGame.getActivePlayer();
            GameDTO modifiedGame = this.gameService.nextPlayerTurn(startedGame);
            PlayerDTO playerTurn2 = modifiedGame.getActivePlayer();
            Assert.assertNotEquals(playerTurn1.getId(), playerTurn2.getId());
            
        } catch (GameNullException | PlayerNullException | GameFullException | GameEmptyException | PlayerInGameException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testFindOpenGames() {
        
        List<GameDTO> openGames = this.gameService.findOpen();
        Assert.assertEquals(1, openGames.size());
        
    }
}
