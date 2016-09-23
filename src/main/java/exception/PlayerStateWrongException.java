package exception;

/**
 *
 * @author renzobelve
 */
public class PlayerStateWrongException extends Exception{
    
    public PlayerStateWrongException(){
        super("No se puede aplicar el cambio de estado del jugador");
    }
    
}
