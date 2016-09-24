package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Renzo Belvedere
 *
 * Clase que representa un Casillero en el Tablero
 */
@Entity
class Slot {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int positionX;

    @Column(nullable = false)
    private int positionY;

    @ManyToOne
    private Player owner;

    @ManyToOne
    private Player board;

    // Constructors ----------------------------
    protected Slot() {
    }

    public Slot(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.owner = null;
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
     * @return the positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * @return the positionY
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * @return the owner
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * @return the board
     */
    public Player getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Player board) {
        this.board = board;
    }

}
