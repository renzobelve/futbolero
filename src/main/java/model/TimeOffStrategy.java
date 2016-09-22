package model;

import exception.SituationWrongException;

/**
 *
 * @author renzobelve
 *
 * Clase que representa la estrategia de Tiempo de Descuento
 */
public class TimeOffStrategy implements SituationCardStrategy {

    @Override
    public void executeAction(Player targetPlayer) throws SituationWrongException {
        if (targetPlayer.getAnswerTime() != Question.QUESTION_TIME) {
            throw new SituationWrongException("El jugador objetivo ya esta con tiempo de descuento");
        } else {
            targetPlayer.setAnswerTime(Question.QUESTION_TIME / 2);
        }
    }

}
