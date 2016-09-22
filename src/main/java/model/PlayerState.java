package model;

import exception.SituationWrongException;
import java.util.List;

/**
 *
 * @author renzobelve
 *
 * Clase abstracta que representa el estado de un Jugador
 */
public abstract class PlayerState {

    private Player player;
    
    // Constructors ----------------------------
    public PlayerState(Player player){
        this.player = player;
    }

    // Getters & Setters ----------------------------
    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    // Methods ----------------------------
    /**
     * @param state
     * 
     * Metodo que cambia de estado a un Jugador
     */
    public void changeState(PlayerState state) {
        this.getPlayer().setState(state);
    }
    
    /**
     * Metodo que inicia el turno del Jugador
     */
    public abstract void playTurn();

    /**
     * @param question
     *
     * Metodo que selecciona una pregunta disponible y la setea como
     * challangeQuestion del jugador retado
     */
    public abstract void selectQuestion(Question question);

    /**
     * Metodo que cambia la pregunta actual del jugador por otra de forma
     * aleatoria
     */
    public abstract void changeQuestion();

    /**
     * Metodo que invalida la pregunta actual y vuelve a iniciar el turno del
     * jugador
     */
    public abstract void invalidateQuestion();

    /**
     * @param questions
     * 
     * Metodo que incorpora nuevas preguntas al terminarse el pool de preguntas
     * disponibles
     */
    public abstract void drawQuestions(List<Question> questions);

    /**
     * @param answer
     * @return boolean
     *
     * Metodo que realiza la respuesta a la pregunta actual y retorna el
     * resultado
     */
    public abstract boolean answerQuestion(Answer answer);

    /**
     *
     * Metodo que cambia la cantidad de tiempo disponible para una respuesta
     */
    public abstract void changeAnswerTime();

    /**
     *
     * Metodo que descarta posibles respuestas falsas
     */
    public abstract void discardAnswers();

    /**
     * @param situationCard
     * @param targetPlayer
     * @throws SituationWrongException
     *
     * Metodo que selecciona una situacion y aplica sus efectos a un jugador
     */
    public abstract void playSituation(SituationCard situationCard, Player targetPlayer) throws SituationWrongException;

    /**
     * Metodo que incorpora una nueva situavion al pool de situaciones
     * disponibles
     */
    public abstract void drawSituation();

    /**
     * @param player
     *
     * Metodo que selecciona a un jugador como retador
     */
    public abstract void selectAsChallanger(Player player);

    /**
     * @param slot
     *
     * Metodo que selecciona un casillero del tablero y lo asigna al jugador
     */
    public abstract void obtainSlot(Slot slot);

    /**
     * @param oldSlot
     * @param newSlot
     *
     * Metodo que cambia la posicion de un casillero a otro vacio para el
     * jugador
     */
    public abstract void changeSlot(Slot oldSlot, Slot newSlot);

    /**
     * @param slot
     *
     * Metodo que deja vacio un slot
     */
    public abstract void emptySlot(Slot slot);

    /**
     *
     * Metodo que finaliza el turno del jugador
     */
    public abstract void finishTurn();
    

}
