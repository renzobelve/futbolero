package model;

import exception.SlotEmptyException;
import exception.SlotFullException;
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
public class BoardTest {

    private Game fourPlayerGame;
    private Board board;
    private Slot slot;
    private Player player;

    @Before
    public void init() {
        this.fourPlayerGame = new Game(4);
        this.board = this.fourPlayerGame.getBoard();
        this.slot = board.getSlots().get(0);
        this.player = new Player("Jugador 1");
        this.slot.setOwner(this.player);
    }

    @Test
    public void testBoardInit() {
        Assert.assertEquals(25, board.getSlots().size());
    }

    @Test
    public void testEmptySlot() {
        try {
            this.board.emptySlot(slot);
            Assert.assertNull(slot.getOwner());
        } catch (SlotEmptyException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testChangeSlot() {
        // Test with empty slot
        Slot newSlot = this.board.getSlots().get(1);
        Assert.assertEquals(this.player, this.slot.getOwner());
        try {
            this.board.changeSlot(this.slot, newSlot);
        } catch (SlotFullException | SlotEmptyException ex) {
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertEquals(this.player, newSlot.getOwner());
        Assert.assertNull(this.slot.getOwner());

        // Test with full slot
        Player player2 = new Player("Jugador 2");
        this.slot.setOwner(player2);
        try {
            this.board.changeSlot(this.slot, newSlot);
        } catch (SlotFullException | SlotEmptyException ex) {
            Assert.assertEquals(new SlotFullException().getMessage(), ex.getMessage());
        }
    }

    @Test
    public void testObtainSlot() {
        // Test with full slot
        Player player2 = new Player("Jugador 2");
        try {
            this.board.obtainSlot(player2, this.slot);
        } catch (SlotFullException ex) {
            Assert.assertEquals(new SlotFullException().getMessage(), ex.getMessage());
        }
        
        //Test with empty slot
        try {    
            this.board.obtainSlot(player2, this.board.getSlots().get(1));
            Assert.assertEquals(player2, this.board.getSlots().get(1).getOwner());
        } catch (SlotFullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testSearchHorizontalLine() {
        this.board.getSlots().get(5).setOwner(this.player);
        this.board.getSlots().get(6).setOwner(this.player);
        this.board.getSlots().get(7).setOwner(this.player);
        this.board.getSlots().get(8).setOwner(this.player);
        
        boolean result = this.board.searchLine(this.player);
        Assert.assertTrue(result);
    }
    
    @Test
    public void testSearchVerticalLine() {
        this.board.getSlots().get(9).setOwner(this.player);
        this.board.getSlots().get(14).setOwner(this.player);
        this.board.getSlots().get(19).setOwner(this.player);
        this.board.getSlots().get(24).setOwner(this.player);
        
        boolean result = this.board.searchLine(this.player);
        Assert.assertTrue(result);
    }
    
    @Test
    public void testSearchDescDiagonalLine() {
        this.board.getSlots().get(5).setOwner(this.player);
        this.board.getSlots().get(11).setOwner(this.player);
        this.board.getSlots().get(17).setOwner(this.player);
        this.board.getSlots().get(23).setOwner(this.player);
        
        boolean result = this.board.searchLine(this.player);
        Assert.assertTrue(result);
    }
    
    @Test
    public void testSearchAscDiagonalLine() {
        this.board.getSlots().get(4).setOwner(this.player);
        this.board.getSlots().get(8).setOwner(this.player);
        this.board.getSlots().get(12).setOwner(this.player);
        this.board.getSlots().get(16).setOwner(this.player);
        
        boolean result = this.board.searchLine(this.player);
        Assert.assertTrue(result);
    }

}
