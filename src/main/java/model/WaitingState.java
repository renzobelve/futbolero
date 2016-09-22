package model;

import exception.SituationWrongException;
import java.util.List;

/**
 *
 * @author renzobelve
 * 
 * Clase que representa el estado de Waiting
 */
public class WaitingState extends PlayerState{

    public WaitingState(Player player) {
        super(player);
    }

    @Override
    public void playTurn() {
        this.changeState(new StartState(this.getPlayer()));
    }

    @Override
    public void selectQuestion(Question question) {
        this.getPlayer().getChallanger().setChallangeQuestion(question);
        this.getPlayer().getQuestions().remove(question);
        if(this.getPlayer().getQuestions().isEmpty()){
            this.getPlayer().setHasToDrawQuestion(true);
        }
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
        this.getPlayer().setQuestions(questions);
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
        situationCard.executeAction(targetPlayer);
    }

    @Override
    public void drawSituation() {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }

    @Override
    public void selectAsChallanger(Player player) {
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
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
        throw new UnsupportedOperationException("No se puede realizar esta accion en este estado");
    }
    
}
