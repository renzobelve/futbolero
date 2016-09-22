package exception;

/**
 *
 * @author renzobelve
 */
public class GameEmptyException extends Exception{
    
    public GameEmptyException(){
        super("No se puede iniciar un Juego si aun no esta completo");
    }
    
}
