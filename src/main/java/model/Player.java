package model;

import exception.SituationWrongException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renzo Belvedere
 *
 * Clase que representa un Jugador
 */
class Player {

    // Variables de instancia generales
    private String name;
    private List<Slot> slots;
    private Game actualGame;
    private List<Question> questions;
    private Question challangeQuestion;
    private Player challanger;
    private List<SituationCard> situationCards;
    private PlayerState state;

    // Variables de instancia de estado
    private int countWarnings;
    private int countExpulsions;
    private boolean isOffside;
    private boolean hasChange;
    private int countAnswers;
    private int answerTime;
    private boolean hasNextTurn;

    // Constructors ----------------------------
    public Player(String name) {
        this.name = name;
        this.slots = new ArrayList<>();
        this.actualGame = null;
        this.questions = new ArrayList<>();
        this.challangeQuestion = null;
        this.challanger = null;
        this.situationCards = new ArrayList<>();
        this.state = new WaitingState(this);
        this.countWarnings = 0;
        this.countExpulsions = 0;
        this.isOffside = false;
        this.hasChange = false;
        this.countAnswers = Question.QUESTION_ANSWERS;
        this.answerTime = Question.QUESTION_TIME;
        this.hasNextTurn = true;
    }

    // Getters & Setters ----------------------------
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
     * @return the slots
     */
    public List<Slot> getSlots() {
        return slots;
    }

    /**
     * @param slots the slots to set
     */
    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    /**
     * @param slot the slot to add
     */
    public void addSlot(Slot slot) {
        this.getSlots().add(slot);
    }

    /**
     * @param slot the slot to remove
     */
    public void removeSlot(Slot slot) {
        this.getSlots().remove(slot);
    }

    /**
     * @return the actualGame
     */
    public Game getActualGame() {
        return actualGame;
    }

    /**
     * @param actualGame the actualGame to set
     */
    public void setActualGame(Game actualGame) {
        this.actualGame = actualGame;
    }

    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * @return the challangeQuestion
     */
    public Question getChallangeQuestion() {
        return challangeQuestion;
    }

    /**
     * @param challangeQuestion the challangeQuestion to set
     */
    public void setChallangeQuestion(Question challangeQuestion) {
        this.challangeQuestion = challangeQuestion;
    }

    /**
     * @return the challanger
     */
    public Player getChallanger() {
        return challanger;
    }

    /**
     * @param challanger the challanger to set
     */
    public void setChallanger(Player challanger) {
        this.challanger = challanger;
    }

    /**
     * @return the state
     */
    public PlayerState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(PlayerState state) {
        this.state = state;
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
     * @return the situationCards
     */
    public List<SituationCard> getSituationCards() {
        return situationCards;
    }

    /**
     * @param situationCards the situationCards to set
     */
    public void setSituationCards(List<SituationCard> situationCards) {
        this.situationCards = situationCards;
    }

    // Methods ----------------------------
    /**
     * Metodo que inicia el turno del Jugador
     */
    public void playTurn() {
        this.getState().playTurn();
    }

    /**
     * @param question
     * @param player
     *
     * Metodo que selecciona una pregunta disponible y la setea como
     * challangeQuestion del jugador retado
     */
    public void selectQuestion(Question question, Player player) {
        this.getState().selectQuestion(question, player);
    }

    /**
     * Metodo que cambia la pregunta actual del jugador por otra de forma
     * aleatoria
     */
    public void changeQuestion() {
        this.getState().changeQuestion();
    }

    /**
     * Metodo que invalida la pregunta actual y vuelve a iniciar el turno del
     * jugador
     */
    public void invalidateQuestion() {
        this.getState().invalidateQuestion();
    }

    /**
     * Metodo que incorpora nuevas preguntas al terminarse el pool de preguntas
     * disponibles
     */
    public void drawQuestions(List<Question> questions) {
        this.getState().drawQuestions(questions);
    }

    /**
     * @param answer
     * @return boolean
     *
     * Metodo que realiza la respuesta a la pregunta actual y retorna el
     * resultado
     */
    public boolean answerQuestion(Answer answer) {
        // TO-DO
        return this.getState().answerQuestion(answer);
    }

    /**
     * @param time
     *
     * Metodo que cambia la cantidad de tiempo disponible para una respuesta
     */
    public void changeAnswerTime(int time) {
        this.getState().changeAnswerTime(time);
    }

    /**
     * @param countDiscard
     *
     * Metodo que descarta posibles respuestas falsas
     */
    public void discardAnswers(int countDiscard) {
        this.getState().discardAnswers(countDiscard);
    }

    /**
     * @param situationCard
     * @param targetPlayer
     * @throws SituationWrongException
     *
     * Metodo que selecciona una situacion y aplica sus efectos a un jugador
     */
    public void playSituation(SituationCard situationCard, Player targetPlayer) throws SituationWrongException {
        this.getState().playSituation(situationCard, targetPlayer);
    }

    /**
     * Metodo que incorpora una nueva situavion al pool de situaciones
     * disponibles
     */
    public void drawSituation() {
        this.getState().drawSituation();
    }

    /**
     * @param player
     *
     * Metodo que selecciona a un jugador como retador
     */
    public void selectChallanger(Player player) {
        this.getState().selectChallanger(player);
    }

    /**
     * @param slot
     *
     * Metodo que selecciona un casillero del tablero y lo asigna al jugador
     */
    public void obtainSlot(Slot slot) {
        this.getState().obtainSlot(slot);
    }

    /**
     * @param oldSlot
     * @param newSlot
     *
     * Metodo que cambia la posicion de un casillero a otro vacio para el
     * jugador
     */
    public void changeSlot(Slot oldSlot, Slot newSlot) {
        this.getState().changeSlot(oldSlot, newSlot);
    }

    /**
     * @param slot
     *
     * Metodo que deja vacio un slot
     */
    public void emptySlot(Slot slot) {
        this.getState().emptySlot(slot);
    }

    /**
     *
     * Metodo que finaliza el turno del jugador
     */
    public void finishTurn() {
        this.getState().finishTurn();
    }

}
