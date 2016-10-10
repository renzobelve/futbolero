package exception;

/**
 *
 * @author renzobelve
 */
public class QuestionNullException extends Exception{
    
    public QuestionNullException(){
        super("La pregunta solicitada no existe");
    }
    
}
