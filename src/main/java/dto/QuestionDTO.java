package dto;

import java.util.List;

/**
 *
 * @author renzobelve
 * 
 * Clase para transferencia de datos de Game
 */
public class QuestionDTO {
    
    private Long id;
    private String question;
    private int answerTime;
    private List<AnswerDTO> answers;

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
    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
