package exception;

/**
 *
 * @author renzobelve
 */
public class SituationCardNullException extends Exception{
    
    public SituationCardNullException(){
        super("La situacion solicitada no existe");
    }
    
}
