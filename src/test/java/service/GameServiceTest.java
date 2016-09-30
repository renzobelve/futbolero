package service;


import app.Application;
import dto.GameDTO;
import dto.PlayerDTO;
import exception.GameEmptyException;
import exception.GameFullException;
import exception.GameNullException;
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
    
    
    @Test
    public void testCreateGame(){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setPlayerAmount(4);
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId((long) 55);
        gameDTO.setCreator(playerDTO);
        
        try {
            GameDTO newGame = this.gameService.createGame(gameDTO);
            Assert.assertNotNull(newGame.getId());
            Assert.assertEquals(1, newGame.getPlayers().size());
            Assert.assertEquals(newGame.getId(), newGame.getPlayers().get(0).getActualGame().getId());
        } catch (GameFullException | GameEmptyException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testFindGame(){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId((long) 1);
        
        try {
            GameDTO retrievedGame = this.gameService.findOneById(gameDTO);
            Assert.assertNotNull(retrievedGame.getId());
        } catch (GameNullException ex) {
            Assert.fail(ex.getMessage());
        }
    
    }
    
}
