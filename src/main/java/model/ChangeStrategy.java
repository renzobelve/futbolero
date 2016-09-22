package model;

import exception.SituationWrongException;

/**
 *
 * @author renzobelve
 *
 * Clase que representa la estrategia de Cambio
 */
public class ChangeStrategy implements SituationCardStrategy {

    @Override
    public void executeAction(Player targetPlayer) throws SituationWrongException {
        if (targetPlayer.isHasChange()) {
            throw new SituationWrongException("El jugador objetivo ya tiene un cambio");
        } else {
            targetPlayer.setHasChange(true);
        }
    }

}
