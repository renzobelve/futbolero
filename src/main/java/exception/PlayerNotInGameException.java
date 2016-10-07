package exception;

/**
 *
 * @author renzobelve
 */
public class PlayerNotInGameException extends Exception{
    
    public PlayerNotInGameException(){
        super("El jugador no se encuentra en el juego");
    }
    
}
