package exception;

/**
 *
 * @author renzobelve
 */
public class GameFullException extends Exception{
    
    public GameFullException(){
        super("El Juego ya esta completo, no puede recibir mas jugadores");
    }
    
}
