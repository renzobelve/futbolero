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
    private List<SlotDTO> slots;
    private PlayerDTO challenger;
    private int countWarnings;
    private int countExpulsions;
    private boolean isOffside;
    private boolean hasChange;
    private int countAnswers;
    private int answerTime;
    private boolean hasNextTurn;
    private boolean hasToDrawQuestion;
    
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

    /**
     * @return the slots
     */
    public List<SlotDTO> getSlots() {
        return slots;
    }

    /**
     * @param slots the slots to set
     */
    public void setSlots(List<SlotDTO> slots) {
        this.slots = slots;
    }

    /**
     * @return the challenger
     */
    public PlayerDTO getChallenger() {
        return challenger;
    }

    /**
     * @param challenger the challenger to set
     */
    public void setChallenger(PlayerDTO challenger) {
        this.challenger = challenger;
    }

    /**
     * @return the countWarnings
     */
    public int getCountWarnings() {
        return countWarnings;
    }

    /**
     * @param countWarnings the countWarnings to set
     */
    public void setCountWarnings(int countWarnings) {
        this.countWarnings = countWarnings;
    }

    /**
     * @return the countExpulsions
     */
    public int getCountExpulsions() {
        return countExpulsions;
    }

    /**
     * @param countExpulsions the countExpulsions to set
     */
    public void setCountExpulsions(int countExpulsions) {
        this.countExpulsions = countExpulsions;
    }

    /**
     * @return the isOffside
     */
    public boolean isIsOffside() {
        return isOffside;
    }

    /**
     * @param isOffside the isOffside to set
     */
    public void setIsOffside(boolean isOffside) {
        this.isOffside = isOffside;
    }

    /**
     * @return the hasChange
     */
    public boolean isHasChange() {
        return hasChange;
    }

    /**
     * @param hasChange the hasChange to set
     */
    public void setHasChange(boolean hasChange) {
        this.hasChange = hasChange;
    }

    /**
     * @return the countAnswers
     */
    public int getCountAnswers() {
        return countAnswers;
    }

    /**
     * @param countAnswers the countAnswers to set
     */
    public void setCountAnswers(int countAnswers) {
        this.countAnswers = countAnswers;
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
     * @return the hasNextTurn
     */
    public boolean isHasNextTurn() {
        return hasNextTurn;
    }

    /**
     * @param hasNextTurn the hasNextTurn to set
     */
    public void setHasNextTurn(boolean hasNextTurn) {
        this.hasNextTurn = hasNextTurn;
    }

    /**
     * @return the hasToDrawQuestion
     */
    public boolean isHasToDrawQuestion() {
        return hasToDrawQuestion;
    }

    /**
     * @param hasToDrawQuestion the hasToDrawQuestion to set
     */
    public void setHasToDrawQuestion(boolean hasToDrawQuestion) {
        this.hasToDrawQuestion = hasToDrawQuestion;
    }
    
}
