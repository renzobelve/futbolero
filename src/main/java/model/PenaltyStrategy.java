package model;

import exception.SituationWrongException;

/**
 *
 * @author renzobelve
 *
 * Clase que representa la estrategia de Penal
 */
public class PenaltyStrategy implements SituationCardStrategy {

    @Override
    public void executeAction(Player targetPlayer) throws SituationWrongException {
        if (targetPlayer.getCountAnswers() != Question.QUESTION_ANSWERS) {
            throw new SituationWrongException("El jugador objetivo ya tiene cobrado un tiro libre o un penal");
        } else {
            targetPlayer.setCountAnswers(targetPlayer.getCountAnswers() - 2);
        }
    }

}
