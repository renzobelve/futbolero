package model;

import exception.GameEmptyException;
import exception.GameFullException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Renzo Belvedere
 *
 * Clase que representa un Juego dentro de Futbolero
 */
@Entity
public class Game {

    public static final int GAME_SIZE = 5;
    public static final int LINE_SIZE = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private int playerAmount;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Board board;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "actualGame")
    private List<Player> players;
    
    @OneToOne
    private Player activePlayer;
    
    @Column(nullable = false)
    private int activePlayerNumber;

    // Constructors ----------------------------
    protected Game() {
    }

    public Game(int playerAmount) {
        this.type = "NORMAL";
        this.playerAmount = playerAmount;
        this.players = new ArrayList<>();
        this.board = new Board(Game.GAME_SIZE, Game.GAME_SIZE);
    }

    // Getters & Setters ----------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the playerNumber
     */
    public int getPlayerAmount() {
        return playerAmount;
    }

    /**
     * @param playerAmount the playerAmount to set
     */
    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * @param player the player to add
     * @throws exception.GameFullException
     * @throws exception.GameEmptyException
     *
     * Metodo que agrega un Jugador al Juego
     *
     */
    public void addPlayer(Player player) throws GameFullException, GameEmptyException {

        // Agrega un Jugador al jugador al Juego si no esta lleno
        if (this.getPlayerAmount() > this.getPlayers().size()) {
            this.getPlayers().add(player);
            player.setActualGame(this);

            // Inicia el Juego si ya esta lleno
            if (this.getPlayerAmount() == this.getPlayers().size()) {
                this.startGame();
            }
        } else {
            throw new GameFullException();
        }

    }

    /**
     * @param player the player to remove
     */
    public void removePlayer(Player player) {
        this.getPlayers().remove(player);
    }

    /**
     * @return the activePlayer
     */
    public Player getActivePlayer() {
        return activePlayer;
    }

    /**
     * @param activePlayer the activePlayer to set
     */
    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * @return the activePlayerNumber
     */
    public int getActivePlayerNumber() {
        return activePlayerNumber;
    }

    /**
     * @param activePlayerNumber the activePlayerNumber to set
     */
    public void setActivePlayerNumber(int activePlayerNumber) {
        this.activePlayerNumber = activePlayerNumber;
    }

    // Methods ----------------------------
    /**
     * @return Player.
     *
     * Metodo que chequea si alguno de los Jugadores es el ganador del Juego y
     * retorna al mismo
     */
    public Player checkWinner() {
        Player winner = null;
        // Chequea si algun jugador formo una linea
        for (Player player : this.getPlayers()) {
            if (this.getBoard().searchLine(player)) {
                winner = player;
            }
        }
        // En caso de empate y si el tablero esta lleno, chequea el jugador con mas pelotas
        if (winner == null && this.isGameFull()) {
            int maxCountBalls = -1;
            for (Player player : this.getPlayers()) {
                if (player.getSlots().size() > maxCountBalls) {
                    maxCountBalls = player.getSlots().size();
                    winner = player;
                }
            }

        }
        //TO-DO caso que aun siga en empate
        return winner;
    }

    /**
     * @return boolean
     *
     * Metodo que chequea si el juego no tiene casilleros libres
     */
    public boolean isGameFull() {
        int countSlots = 0;
        for (Player player : this.getPlayers()) {
            countSlots = countSlots + player.getSlots().size();
        }
        if (countSlots == (this.getBoard().getHeight() * this.getBoard().getWidth())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que inicia el turno del siguiente Jugador que corresponde a la
     * ronda del Juego
     *
     */
    public void nextPlayerTurn() {
        this.getPlayers().get(this.getActivePlayerNumber()).playTurn();
        this.setActivePlayerNumber((this.getActivePlayerNumber() + 1) % this.getPlayers().size());
    }

    /**
     * @throws exception.GameEmptyException
     *
     * Metodo que inicia el Juego y setea de forma random al primer Jugador en
     * iniciar el turno
     */
    public void startGame() throws GameEmptyException {

        if (this.getPlayers().size() == this.getPlayerAmount()) {
            // Determina de forma aleatoria el primer Jugador
            Random randomNumber = new Random();
            int randomPlayerNumber = randomNumber.nextInt(this.getPlayers().size());
            this.setActivePlayerNumber(randomPlayerNumber);
            this.setActivePlayer(this.getPlayers().get(this.getActivePlayerNumber()));

            // Inicializa el Juego
            this.nextPlayerTurn();
        } else {
            throw new GameEmptyException();
        }

    }

}
