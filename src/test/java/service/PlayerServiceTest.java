package service;

import app.Application;
import dto.PlayerDTO;
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
 * Clase que testea actividades y funcionamiento de QuestionService
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @Test
    public void testFindAllPlayers() {
        List<PlayerDTO> players = this.playerService.findAll();
        Assert.assertEquals(9, players.size());
    }

    @Test
    public void testCreatePlayer() {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Jugador Test");

        try {
            PlayerDTO newPlayerDTO = this.playerService.createPlayer(playerDTO);
            Assert.assertNotNull(newPlayerDTO.getId());
            newPlayerDTO = this.playerService.findOneById(newPlayerDTO.getId());
            Assert.assertEquals("Jugador Test", newPlayerDTO.getName());
            Assert.assertNull(newPlayerDTO.getActualGame());
            Assert.assertNull(newPlayerDTO.getSlots());
            Assert.assertNull(newPlayerDTO.getChallengeQuestion());
            Assert.assertNull(newPlayerDTO.getQuestions());
            Assert.assertNull(newPlayerDTO.getSituationCards());
            Assert.assertNull(newPlayerDTO.getChallenger());
            Assert.assertEquals(0, newPlayerDTO.getCountWarnings());
            Assert.assertEquals(0, newPlayerDTO.getCountExpulsions());
            Assert.assertEquals(4, newPlayerDTO.getCountAnswers());
            Assert.assertEquals(20, newPlayerDTO.getAnswerTime());
            Assert.assertFalse(newPlayerDTO.isHasChange());
            Assert.assertFalse(newPlayerDTO.isIsOffside());
            Assert.assertFalse(newPlayerDTO.isHasToDrawQuestion());
            Assert.assertTrue(newPlayerDTO.isHasNextTurn());
        } catch (PlayerNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    

}
