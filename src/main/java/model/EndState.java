package model;

import exception.PlayerStateWrongException;
import exception.SituationWrongException;
import exception.SlotEmptyException;
import exception.SlotFullException;
import java.util.List;

/**
 *
 * @author renzobelve
 *
 * Clase que representa el estado End
 */
public class EndState extends PlayerState {

    public EndState(Player player) {
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
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
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
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
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
        this.getPlayer().setChallangeQuestion(null);
        this.getPlayer().getChallanger().setChallanger(null);
        this.getPlayer().setChallanger(null);
        this.changeState(new WaitingState(this.getPlayer()));
    }

}
