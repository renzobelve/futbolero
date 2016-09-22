package exception;

/**
 *
 * @author renzobelve
 */
public class QuestionMalformedException extends Exception{
    
    public QuestionMalformedException(){
        super("La pregunta tiene que tener 4 respuestas posibles y solo una debe ser verdadera");
    }
    
}
