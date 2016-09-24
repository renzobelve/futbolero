package model;

import exception.PlayerStateWrongException;
import exception.SituationWrongException;
import exception.SlotEmptyException;
import exception.SlotFullException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author renzobelve
 *
 * Clase abstracta que representa el estado de un Jugador
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PlayerState {

    @Id
    @GeneratedValue
    private Long id;
    
    @OneToOne
    private Player player;

    // Constructors ----------------------------
    protected PlayerState(){}
    
    public PlayerState(Player player) {
        this.player = player;
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
     * @throws exception.PlayerStateWrongException
     *
     * Metodo que cambia la pregunta actual del jugador por otra de forma
     * aleatoria
     */
    public abstract void changeQuestion() throws PlayerStateWrongException;

    /**
     * @throws exception.PlayerStateWrongException
     *
     * Metodo que invalida la pregunta actual y vuelve a iniciar el turno del
     * jugador
     */
    public abstract void invalidateQuestion() throws PlayerStateWrongException;

    /**
     * @param questions
     * @throws exception.PlayerStateWrongException
     *
     * Metodo que incorpora nuevas preguntas al terminarse el pool de preguntas
     * disponibles
     */
    public abstract void drawQuestions(List<Question> questions) throws PlayerStateWrongException;

    /**
     * @param answer
     * @return boolean
     *
     * Metodo que realiza la respuesta a la pregunta actual y retorna el
     * resultado
     */
    public abstract boolean answerQuestion(Answer answer);

    /**
     * @throws exception.PlayerStateWrongException
     *
     * Metodo que cambia la cantidad de tiempo disponible para una respuesta
     */
    public abstract void changeAnswerTime() throws PlayerStateWrongException;

    /**
     * @throws exception.PlayerStateWrongException
     *
     * Metodo que descarta posibles respuestas falsas
     */
    public abstract void discardAnswers() throws PlayerStateWrongException;

    /**
     * @param situationCard
     * @param targetPlayer
     * @throws SituationWrongException
     *
     * Metodo que selecciona una situacion y aplica sus efectos a un jugador
     */
    public abstract void playSituation(SituationCard situationCard, Player targetPlayer) throws SituationWrongException;

    /**
     * @param situationCard
     *
     * Metodo que incorpora una nueva situavion al pool de situaciones
     * disponibles
     */
    public abstract void drawSituation(SituationCard situationCard);

    /**
     * @param player
     *
     * Metodo que selecciona a un jugador como retador
     */
    public abstract void selectAsChallanger(Player player);

    /**
     * @param slot
     * @throws exception.SlotFullException
     *
     * Metodo que selecciona un casillero del tablero y lo asigna al jugador
     *
     */
    public abstract void obtainSlot(Slot slot) throws SlotFullException;

    /**
     * @param oldSlot
     * @param newSlot
     * @throws exception.SlotFullException
     * @throws exception.SlotEmptyException
     * @throws exception.PlayerStateWrongException
     *
     * Metodo que cambia la posicion de un casillero a otro vacio para el
     * jugador

     */
    public abstract void changeSlot(Slot oldSlot, Slot newSlot) throws SlotFullException, SlotEmptyException, PlayerStateWrongException;

    /**
     * @param slot
     * @throws exception.SlotEmptyException
     * @throws exception.PlayerStateWrongException
     * 
     * Metodo que deja vacio un slot
     */
    public abstract void emptySlot(Slot slot) throws SlotEmptyException, PlayerStateWrongException;

    /**
     *
     * Metodo que finaliza el turno del jugador
     */
    public abstract void finishTurn();

}
