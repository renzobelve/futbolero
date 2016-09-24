package model;

import exception.SituationWrongException;

/**
 *
 * @author renzobelve
 *
 * Interfaz que representa la estrategia a utilizar en cada tarjeta de situacion
 */
public interface SituationCardStrategy {
    public void executeAction(Player targetPlayer) throws SituationWrongException;

}
