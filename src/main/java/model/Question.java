package model;

import exception.QuestionMalformedException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author renzobelve
 *
 * Clase que representa una Pregunta para los juegos
 */
@Entity
public class Question {

    public static final int QUESTION_TIME = 20;
    public static final int QUESTION_ANSWERS = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private int answerTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    // Constructors ----------------------------
    protected Question() {
    }

    public Question(String question, List<Answer> answers) throws QuestionMalformedException {
        this.question = question;
        this.answerTime = Question.QUESTION_TIME;
        this.answers = new ArrayList<>();

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
        for (Answer answer : answers) {
            this.addAnswer(answer);
        }

    }

    // Getters & Setters ----------------------------
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * @param answer the answer to add
     */
    private void addAnswer(Answer answer) {
        answer.setQuestion(this);
        this.getAnswers().add(answer);
    }

    /**
     * @param answer the answer to remove
     */
    private void removeAnswer(Answer answer) {
        this.getAnswers().remove(answer);
    }

    // Methods ----------------------------
    public boolean checkIsCorrect(Answer answer) {
        return answer.isIsCorrect();
    }

}
