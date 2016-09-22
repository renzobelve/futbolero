package model;

/**
 *
 * @author renzobelve
 *
 * Clase que representa la estrategia de Expulsion
 */
public class ExpulsionStrategy implements SituationCardStrategy {

    @Override
    public void executeAction(Player targetPlayer) {
        targetPlayer.setCountExpulsions(targetPlayer.getCountExpulsions() + 1);
    }

}
