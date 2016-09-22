package model;

import exception.QuestionMalformedException;
import java.util.List;

/**
 *
 * @author renzobelve
 *
 * Clase que representa una Pregunta para los juegos
 */
public class Question {

    public static final int QUESTION_TIME = 20;
    public static final int QUESTION_ANSWERS = 4;

    private String question;
    private int answerTime;
    private List<Answer> answers;

    // Constructors ----------------------------
    public Question(String question, List<Answer> answers) throws QuestionMalformedException {
        this.question = question;
        this.answerTime = Question.QUESTION_TIME;
        
        // Chequea si las respuestas dadas son 4 posibles
        if (answers.size() != Question.QUESTION_ANSWERS) {
            throw new QuestionMalformedException();
        }
        // Chequea si solo una de las respuestas dadas es verdadera
        int countTrue = 0;
        for (Answer answer : answers) {
            if (answer.isIsCorrect()) {
                countTrue++;
            }
        }
        if (countTrue != 1) {
            throw new QuestionMalformedException();
        }
        // Si pasa los chequeos se asigna a la variable de instancia
        this.answers = answers;

    }

    // Getters & Setters ----------------------------
    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the answerTime
     */
    public int getAnswerTime() {
        return answerTime;
    }

    /**
     * @param answerTime the answerTime to set
     */
    public void setAnswerTime(int answerTime) {
        this.answerTime = answerTime;
    }

    /**
     * @return the answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    // Methods ----------------------------
    public boolean checkIsCorrect(Answer answer) {
        return answer.isIsCorrect();
    }

}
