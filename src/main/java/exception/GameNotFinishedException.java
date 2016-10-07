package exception;

/**
 *
 * @author renzobelve
 */
public class GameNotFinishedException extends Exception{
    
    public GameNotFinishedException(){
        super("No se puede eliminar un jugador en un juego empezado");
    }
    
}
