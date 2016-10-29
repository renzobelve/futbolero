package exception;

/**
 *
 * @author renzobelve
 */
public class ChallengerNullException extends Exception{
    
    public ChallengerNullException(){
        super("El jugador todavia no tiene asociado un retador");
    }
    
}
