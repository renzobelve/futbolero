package exception;

/**
 *
 * @author renzobelve
 */
public class GameNotOpenException extends Exception{
    
    public GameNotOpenException(){
        super("No se puede eliminar un juego que no este abierto");
    }
    
}
