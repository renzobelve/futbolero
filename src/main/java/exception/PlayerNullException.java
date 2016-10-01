package exception;

/**
 *
 * @author renzobelve
 */
public class PlayerNullException extends Exception{
    
    public PlayerNullException(){
        super("El jugador solicitado no existe");
    }
    
}
