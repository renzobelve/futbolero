package model;

import exception.SituationWrongException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author renzobelve
 *
 * Clase que representa el estado de Answer
 */
public class AnswerState extends PlayerState {

    public AnswerState(Player player) {
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
        // Determina de forma aleatoria la pregunta para cambiar
        Random randomNumber = new Random();
        int randomQuestionNumber = randomNumber.nextInt(this.getPlayer().getChallanger().getQuestions().size());
        Question questionChange = this.getPlayer().getChallanger().getQuestions().get(randomQuestionNumber);
        // Se cambia la pregunta actual por la nueva
        this.getPlayer().getChallanger().selectQuestion(questionChange);
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
        boolean result = answer.isIsCorrect();
        // Si la respuesta es correcta puede agregar casillero en el tablero, sino el turno finaliza
        if(result){
            this.changeState(new BoardState(this.getPlayer()));
        }else{
            this.finishTurn();
        }
        return answer.isIsCorrect();
    }

    @Override
    public void changeAnswerTime() {
        this.getPlayer().getChallangeQuestion().setAnswerTime(this.getPlayer().getAnswerTime());
    }

    @Override
    public void discardAnswers() {
        // TO-DO
    }

    @Override
    public void playSituation(SituationCard situationCard, Player targetPlayer) throws SituationWrongException {
        // TO-DO
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
        this.changeState(new EndState(this.getPlayer()));
        this.getPlayer().finishTurn();
    }

}
