package model;

import exception.SituationWrongException;

/**
 *
 * @author renzobelve
 *
 * Clase que representa la estrategia de Offside
 */
public class OffsideStrategy implements SituationCardStrategy {

    @Override
    public void executeAction(Player targetPlayer) throws SituationWrongException {
        if (targetPlayer.isIsOffside()) {
            throw new SituationWrongException("El jugador objetivo ya se encuentra en offside");
        } else {
            targetPlayer.setIsOffside(true);
        }
    }

}
