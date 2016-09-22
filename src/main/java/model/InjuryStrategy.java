package model;

import exception.SituationWrongException;

/**
 *
 * @author renzobelve
 *
 * Clase que representa la estrategia de Lesion
 */
public class InjuryStrategy implements SituationCardStrategy {

    @Override
    public void executeAction(Player targetPlayer) throws SituationWrongException {
        if (!targetPlayer.isHasNextTurn()) {
            throw new SituationWrongException("El jugador objetivo ya esta lesionado");
        } else {
            targetPlayer.setHasNextTurn(false);
        }
    }

}
