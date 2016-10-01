package exception;

/**
 *
 * @author renzobelve
 */
public class PlayerInGameException extends Exception{
    
    public PlayerInGameException(){
        super("El jugador ya se encuentra en el juego");
    }
    
}
