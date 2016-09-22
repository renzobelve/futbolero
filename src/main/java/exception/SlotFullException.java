package exception;

/**
 *
 * @author renzobelve
 */
public class SlotFullException extends Exception{
    
    public SlotFullException(){
        super("El casillero no debe pertenecer a ningun jugador");
    }
    
}
