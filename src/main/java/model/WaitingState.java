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
 * Clase que representa el estado de Waiting
 */
@Entity
public class WaitingState extends PlayerState {

    protected WaitingState(){}
    
    public WaitingState(Player player) {
        super(player);
    }

    @Override
    public void playTurn() {
        if (this.getPlayer().isHasNextTurn()) {
            this.changeState(new StartState(this.getPlayer()));
        } else {
            this.finishTurn();
        }
    }

    @Override
    public void selectQuestion(Question question) {
        this.getPlayer().getChallenger().setChallengeQuestion(question);
        this.getPlayer().getQuestions().remove(question);
        if (this.getPlayer().getQuestions().isEmpty()) {
            this.getPlayer().setHasToDrawQuestion(true);
        }
    }

    @Override
    public void changeQuestion() throws PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void invalidateQuestion() throws PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void drawQuestions(List<Question> questions) throws PlayerStateWrongException {
        if (this.getPlayer().isHasToDrawQuestion()) {
            this.getPlayer().setQuestions(questions);
        } else {
            throw new PlayerStateWrongException();
        }
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
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void selectAsChallanger(Player player) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void obtainSlot(Slot slot) throws SlotFullException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void changeSlot(Slot oldSlot, Slot newSlot) throws SlotFullException, SlotEmptyException, PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void emptySlot(Slot slot) throws SlotEmptyException, PlayerStateWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void finishTurn() {
        this.changeState(new EndState(this.getPlayer()));
        this.getPlayer().finishTurn();
    }

}
