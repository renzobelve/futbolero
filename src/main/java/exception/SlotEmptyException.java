package exception;

/**
 *
 * @author renzobelve
 */
public class SlotEmptyException extends Exception{
    
    public SlotEmptyException(){
        super("El casillero no pertenece a ningun jugador");
    }
    
}
