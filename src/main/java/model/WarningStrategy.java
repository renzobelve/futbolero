package model;

/**
 *
 * @author renzobelve
 * 
 * Clase que representa la estrategia de Amonestacion
 */
public class WarningStrategy implements SituationCardStrategy{

    @Override
    public void executeAction(Player targetPlayer) {
        if(targetPlayer.getCountWarnings() == 1){
            targetPlayer.setCountWarnings(0);
            targetPlayer.setCountExpulsions(targetPlayer.getCountExpulsions() + 1);
        }else{
            targetPlayer.setCountWarnings(targetPlayer.getCountWarnings() + 1);
        }
    }
    
}
