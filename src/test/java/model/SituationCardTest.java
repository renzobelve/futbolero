package model;

import exception.SituationWrongException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author renzobelve
 *
 * Clase que testea actividades y funcionamiento de SituationCard y sus
 * estrategias
 */
public class SituationCardTest {

    private Player player;
    private Player targetPlayer;

    @Before
    public void init() {
        this.player = new Player("Jugador 1");
        this.targetPlayer = new Player("Jugador 2");
    }

    @Test
    public void testWarningSituation() {
        SituationCard situationCard = new SituationCard("Amonestacion", "Descripcion Amonestacion");
        situationCard.setWarningStrategy();
        try {
            this.player.playSituation(situationCard, this.targetPlayer);
            Assert.assertEquals(1, this.targetPlayer.getCountWarnings());

            this.player.playSituation(situationCard, this.targetPlayer);
            Assert.assertEquals(0, this.targetPlayer.getCountWarnings());
            Assert.assertEquals(1, this.targetPlayer.getCountExpulsions());
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testExpulsionSituation() {
        SituationCard situationCard = new SituationCard("Expulsion", "Descripcion Expulsion");
        situationCard.setExpulsionStrategy();

        try {
            this.player.playSituation(situationCard, this.targetPlayer);
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertEquals(1, this.targetPlayer.getCountExpulsions());
    }

    @Test
    public void testOffsideSituation() {
        SituationCard situationCard = new SituationCard("Offside", "Descripcion Offside");
        situationCard.setOffsideStrategy();

        try {
            this.player.playSituation(situationCard, this.targetPlayer);
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertTrue(this.targetPlayer.isIsOffside());
    }
    
    @Test
    public void testChangeSituation() {
        SituationCard situationCard = new SituationCard("Cambio", "Descripcion Cambio");
        situationCard.setChangeStrategy();

        try {
            this.player.playSituation(situationCard, this.targetPlayer);
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertTrue(this.targetPlayer.isHasChange());
    }
    
    @Test
    public void testFreeKickSituation() {
        SituationCard situationCard = new SituationCard("Tiro Libre", "Descripcion Tiro Libre");
        situationCard.setFreeKickStrategy();

        try {
            this.player.playSituation(situationCard, this.targetPlayer);
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertEquals(3, this.targetPlayer.getCountAnswers());
    }
    
    @Test
    public void testPenaltySituation() {
        SituationCard situationCard = new SituationCard("Penal", "Descripcion Penal");
        situationCard.setPenaltyStrategy();

        try {
            this.player.playSituation(situationCard, this.targetPlayer);
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertEquals(2, this.targetPlayer.getCountAnswers());
    }
    
    @Test
    public void testInjurySituation() {
        SituationCard situationCard = new SituationCard("Lesion", "Descripcion Lesion");
        situationCard.setInjuryStrategy();

        try {
            this.player.playSituation(situationCard, this.targetPlayer);
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertFalse(this.targetPlayer.isHasNextTurn());
    }
    
    @Test
    public void testTimeOffSituation() {
        SituationCard situationCard = new SituationCard("Tiempo de Descuento", "Descripcion Tiempo de Descuento");
        situationCard.setTimeOffStrategy();

        try {
            this.player.playSituation(situationCard, this.targetPlayer);
        } catch (SituationWrongException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertEquals(10, this.targetPlayer.getAnswerTime());
    }

}
