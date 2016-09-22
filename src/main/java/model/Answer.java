package model;

/**
 *
 * @author renzobelve
 * 
 * Clase que representa una Respuesta para una Pregunta
 */
public class Answer {
    
    private String answer;
    private boolean isCorrect;
    
    // Constructors ----------------------------
    public Answer(String answer, boolean isCorrect){
        this.answer = answer;
        this.isCorrect = isCorrect;
    }
    

    // Getters & Setters ----------------------------
    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the isCorrect
     */
    public boolean isIsCorrect() {
        return isCorrect;
    }

    /**
     * @param isCorrect the isCorrect to set
     */
    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    
}
