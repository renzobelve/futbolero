package exception;

/**
 *
 * @author renzobelve
 */
public class GameNullException extends Exception{
    
    public GameNullException(){
        super("El juego solicitado no existe");
    }
    
}
