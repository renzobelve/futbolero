package model;

import exception.PlayerStateWrongException;
import exception.SituationWrongException;
import exception.SlotEmptyException;
import exception.SlotFullException;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author renzobelve
 *
 * Clase que representa el estado Board
 */
@Entity
public class BoardState extends PlayerState {

    protected BoardState(){}
    
    public BoardState(Player player) {
        super(player);
    }

    @Override
    public void playTurn() {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void selectQuestion(Question question) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void changeQuestion() throws PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void invalidateQuestion() throws PlayerStateWrongException {
        if (this.getPlayer().isIsOffside()) {
            this.getPlayer().setChallengeQuestion(null);
            this.getPlayer().getChallenger().setChallenger(null);
            this.getPlayer().setChallenger(null);
            this.changeState(new StartState(this.getPlayer()));
        } else {
            throw new PlayerStateWrongException();
        }
    }

    @Override
    public void drawQuestions(List<Question> questions) throws PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public boolean answerQuestion(Answer answer) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void changeAnswerTime() throws PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void discardAnswers() throws PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void playSituation(SituationCard situationCard, Player targetPlayer) throws SituationWrongException {
        situationCard.executeAction(targetPlayer);
    }

    @Override
    public void drawSituation(SituationCard situationCard) {
        this.getPlayer().getSituationCards().add(situationCard);
    }

    @Override
    public void selectAsChallanger(Player player) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void obtainSlot(Slot slot) throws SlotFullException {
        this.getPlayer().getActualGame().getBoard().obtainSlot(this.getPlayer(), slot);
        this.finishTurn();
    }

    @Override
    public void changeSlot(Slot oldSlot, Slot newSlot) throws SlotFullException, SlotEmptyException, PlayerStateWrongException {
        if (this.getPlayer().getCountWarnings() > 0) {
            this.getPlayer().getActualGame().getBoard().changeSlot(oldSlot, newSlot);
        } else {
            throw new PlayerStateWrongException();
        }
    }

    @Override
    public void emptySlot(Slot slot) throws SlotEmptyException, PlayerStateWrongException {
        if (this.getPlayer().getCountExpulsions() > 0) {
            this.getPlayer().getActualGame().getBoard().emptySlot(slot);
        }else{
            throw new PlayerStateWrongException();
        }
    }

    @Override
    public void finishTurn() {
        this.changeState(new EndState(this.getPlayer()));
        this.getPlayer().finishTurn();
    }

}
