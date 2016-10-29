package dto;

import java.util.List;

/**
 *
 * @author renzobelve
 * 
 * Clase para transferencia de datos de Player
 */
public class PlayerDTO {
    
    private Long id;
    private String name;
    private GameDTO actualGame;
    private List<QuestionDTO> questions;
    private QuestionDTO challengeQuestion;
    private List<SituationCardDTO> situationCards;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

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
     * @return the actualGame
     */
    public GameDTO getActualGame() {
        return actualGame;
    }

    /**
     * @param actualGame the actualGame to set
     */
    public void setActualGame(GameDTO actualGame) {
        this.actualGame = actualGame;
    }

    /**
     * @return the questions
     */
    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    /**
     * @return the challengeQuestion
     */
    public QuestionDTO getChallengeQuestion() {
        return challengeQuestion;
    }

    /**
     * @param challengeQuestion the challengeQuestion to set
     */
    public void setChallengeQuestion(QuestionDTO challengeQuestion) {
        this.challengeQuestion = challengeQuestion;
    }

    /**
     * @return the situationCards
     */
    public List<SituationCardDTO> getSituationCards() {
        return situationCards;
    }

    /**
     * @param situationCards the situationCards to set
     */
    public void setSituationCards(List<SituationCardDTO> situationCards) {
        this.situationCards = situationCards;
    }
    
}
