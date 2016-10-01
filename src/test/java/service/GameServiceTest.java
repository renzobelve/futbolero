package service;

import app.Application;
import dto.GameDTO;
import dto.PlayerDTO;
import exception.GameEmptyException;
import exception.GameFullException;
import exception.GameNullException;
import exception.PlayerInGameException;
import exception.PlayerNullException;
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

    @Test
    public void testCreateAndJoinAndStartGame() {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setPlayerAmount(4);
        gameDTO.setId((long) 571);
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
            // Test join
            this.gameService.joinGame(newGame, playerDTO2);
            GameDTO createdGame = this.gameService.findOneById((long) 571);
            Assert.assertNotNull(createdGame.getId());
            Assert.assertEquals(2, createdGame.getPlayers().size());
            Assert.assertEquals(createdGame.getId(), createdGame.getPlayers().get(0).getActualGame().getId());
            Assert.assertEquals(createdGame.getId(), createdGame.getPlayers().get(1).getActualGame().getId());
            // Test start
            this.gameService.joinGame(newGame, playerDTO3);
            this.gameService.joinGame(newGame, playerDTO4);
            GameDTO startedGame = this.gameService.findOneById((long) 571);
            Assert.assertNotNull(createdGame.getId());
            Assert.assertEquals(4, startedGame.getPlayers().size());
            Assert.assertEquals(startedGame.getId(), startedGame.getPlayers().get(0).getActualGame().getId());
            Assert.assertEquals(startedGame.getId(), startedGame.getPlayers().get(1).getActualGame().getId());
            Assert.assertEquals(startedGame.getId(), startedGame.getPlayers().get(2).getActualGame().getId());
            Assert.assertEquals(startedGame.getId(), startedGame.getPlayers().get(3).getActualGame().getId());
            Assert.assertNotNull(startedGame.getActivePlayer());
        } catch (GameFullException | GameEmptyException | PlayerNullException | GameNullException | PlayerInGameException ex) {
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
}
