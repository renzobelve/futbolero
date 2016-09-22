package model;

import exception.SituationWrongException;
import java.util.List;

/**
 *
 * @author renzobelve
 *
 * Clase que representa el estado de Start
 */
public class StartState extends PlayerState {

    public StartState(Player player) {
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
    public void changeQuestion() {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void invalidateQuestion() {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void drawQuestions(List<Question> questions) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public boolean answerQuestion(Answer answer) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void changeAnswerTime() {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void discardAnswers() {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void playSituation(SituationCard situationCard, Player targetPlayer) throws SituationWrongException {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void drawSituation() {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void selectAsChallanger(Player player) {
        player.setChallanger(this.getPlayer());
        this.getPlayer().setChallanger(player);
        this.changeState(new AnswerState(this.getPlayer()));
    }

    @Override
    public void obtainSlot(Slot slot) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void changeSlot(Slot oldSlot, Slot newSlot) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void emptySlot(Slot slot) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void finishTurn() {
        this.changeState(new EndState(this.getPlayer()));
        this.getPlayer().finishTurn();
    }

}
