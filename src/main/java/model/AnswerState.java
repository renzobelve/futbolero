package model;

import exception.PlayerStateWrongException;
import exception.SituationWrongException;
import exception.SlotEmptyException;
import exception.SlotFullException;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;

/**
 *
 * @author renzobelve
 *
 * Clase que representa el estado de Answer
 */
@Entity
public class AnswerState extends PlayerState {

    protected AnswerState() {
    }

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
    public void changeQuestion() throws PlayerStateWrongException {
        if (this.getPlayer().isHasChange()) {
            // Determina de forma aleatoria la pregunta para cambiar
            Random randomNumber = new Random();
            int randomQuestionNumber = randomNumber.nextInt(this.getPlayer().getChallenger().getQuestions().size());
            Question questionChange = this.getPlayer().getChallenger().getQuestions().get(randomQuestionNumber);
            // Se cambia la pregunta actual por la nueva
            this.getPlayer().getChallenger().selectQuestion(questionChange);
        } else {
            throw new PlayerStateWrongException();
        }
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
        boolean result = answer.isIsCorrect();
        // Si la respuesta es correcta puede agregar casillero en el tablero, sino el turno finaliza
        if (result) {
            this.changeState(new BoardState(this.getPlayer()));
        } else {
            this.finishTurn();
        }
        return answer.isIsCorrect();
    }

    @Override
    public void changeAnswerTime() throws PlayerStateWrongException {
        if (this.getPlayer().getAnswerTime() < Question.QUESTION_TIME) {
            this.getPlayer().getChallengeQuestion().setAnswerTime(this.getPlayer().getAnswerTime());
        } else {
            throw new PlayerStateWrongException();
        }
    }

    @Override
    public void discardAnswers() throws PlayerStateWrongException {
        if (this.getPlayer().getCountAnswers() < Question.QUESTION_ANSWERS) {
            int answersToDiscount = Question.QUESTION_ANSWERS - this.getPlayer().getCountAnswers();
            for (int i = 0; i < answersToDiscount; i++) {
                Random randomNumber = new Random();
                int randomAnswerNumber = randomNumber.nextInt(this.getPlayer().getChallengeQuestion().getAnswers().size());
                Answer answer = this.getPlayer().getChallengeQuestion().getAnswers().get(randomAnswerNumber);
                if (!answer.isIsCorrect()) {
                    this.getPlayer().getChallengeQuestion().getAnswers().remove(answer);
                } else {
                    i--;
                }
            }
        } else {
            throw new PlayerStateWrongException();
        }
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
