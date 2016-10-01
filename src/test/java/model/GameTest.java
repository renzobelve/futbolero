package model;

import exception.GameEmptyException;
import exception.GameFullException;
import exception.PlayerInGameException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author renzobelve
 *
 * Clase que testea actividades y funcionamiento de Game
 */
public class GameTest {

    private Game fourPlayerGame;

    @Before
    public void init() {
        this.fourPlayerGame = new Game(4);
        try {
            Player player1 = new Player("Jugador 1");
            Player player2 = new Player("Jugador 2");
            this.fourPlayerGame.addPlayer(player1);
            this.fourPlayerGame.addPlayer(player2);
            
            Assert.assertEquals(2, this.fourPlayerGame.getPlayers().size());
            Assert.assertNotNull(player1.getActualGame());
            Assert.assertNotNull(player2.getActualGame());
        } catch (GameFullException | GameEmptyException | PlayerInGameException ex) {
            Assert.fail(ex.getMessage());
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

    }

    @Test
    public void testAddPlayersToGame() {
        try {
            this.fourPlayerGame.addPlayer(new Player("Jugador 3"));
            this.fourPlayerGame.addPlayer(new Player("Jugador 4"));
        } catch (GameFullException | GameEmptyException | PlayerInGameException ex) {
            Assert.fail(ex.getMessage());
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

        Assert.assertEquals(4, this.fourPlayerGame.getPlayers().size());
        Assert.assertNotNull(this.fourPlayerGame.getActivePlayer());
        Assert.assertNotNull(this.fourPlayerGame.getActivePlayerNumber());

    }
    
    @Test
    public void testNextPlayerTurn() {
        try {
            this.fourPlayerGame.addPlayer(new Player("Jugador 3"));
            this.fourPlayerGame.addPlayer(new Player("Jugador 4"));
            
            this.fourPlayerGame.nextPlayerTurn();
            this.fourPlayerGame.nextPlayerTurn();
        } catch (GameFullException | GameEmptyException | PlayerInGameException ex) {
            Assert.fail(ex.getMessage());
            Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        Assert.assertEquals(4, this.fourPlayerGame.getPlayers().size());
        Assert.assertNotNull(this.fourPlayerGame.getActivePlayer());
        Assert.assertNotNull(this.fourPlayerGame.getActivePlayerNumber());
    }
    
    @Test
    public void testCheckWinnerByLine() {
        this.fourPlayerGame.getBoard().getSlots().get(4).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(8).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(12).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(16).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(17).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(18).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(20).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(21).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(22).setOwner(this.fourPlayerGame.getPlayers().get(0));
        
        Player winner = this.fourPlayerGame.checkWinner();
        Assert.assertEquals(this.fourPlayerGame.getPlayers().get(1), winner);
    }
    
    @Test
    public void testCheckWinnerByBalls() {
        this.fourPlayerGame.getBoard().getSlots().get(4).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(8).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(12).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(17).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(18).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(20).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(21).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(22).setOwner(this.fourPlayerGame.getPlayers().get(0));       
        this.fourPlayerGame.getBoard().getSlots().get(1).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(2).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(3).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(5).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(6).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(7).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(9).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(10).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(11).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(13).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(14).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(15).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(16).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(19).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(23).setOwner(this.fourPlayerGame.getPlayers().get(0));
        this.fourPlayerGame.getBoard().getSlots().get(24).setOwner(this.fourPlayerGame.getPlayers().get(1));
        this.fourPlayerGame.getBoard().getSlots().get(0).setOwner(this.fourPlayerGame.getPlayers().get(0));
        
        Player winner = this.fourPlayerGame.checkWinner();
        Assert.assertEquals(this.fourPlayerGame.getPlayers().get(0), winner);
    }

}
