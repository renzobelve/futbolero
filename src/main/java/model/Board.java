package model;

import exception.SlotEmptyException;
import exception.SlotFullException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Renzo Belvedere
 *
 * Clase que representa un Tablero de Juego
 */
@Entity
class Board {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int height;
    
    @Column(nullable = false)
    private int width;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    private List<Slot> slots;

    // Constructors ----------------------------
    protected Board(){}
    
    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.slots = new ArrayList<>();

        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                this.addSlot(new Slot(i, j));
            }
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
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
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
    private void addSlot(Slot slot) {
        this.getSlots().add(slot);
    }

    /**
     * @param slot the slot to remove
     */
    private void removeSlot(Slot slot) {
        this.getSlots().remove(slot);
    }

    // Methods ----------------------------
    /**
     * @param player
     * @return boolean
     *
     * Metodo que busca si un determinado Jugador formo una linea en el Tablero
     */
    public boolean searchLine(Player player) {
        // Se arma matriz de tablero
        int[][] boardMatrix = this.createBoardMatrix(player);
        // Se arma matriz de calculo
        int[][][] searchMatrix = this.createSearchMatrix();
        // Implementar recorrido
        boolean result = search(boardMatrix, searchMatrix);
        return result;
    }

    /**
     * @param player
     * @return int[][]
     *
     * Metodo que representa al tablero como una matriz poniendo en 1 cada
     * casillero de un jugador
     */
    private int[][] createBoardMatrix(Player player) {
        int[][] matrix = new int[this.getWidth() + 2][this.getHeight() + 2];
        for (Slot slot : this.getSlots()) {
            if (slot.getOwner() != null && slot.getOwner().equals(player)) {
                matrix[slot.getPositionX()][slot.getPositionY()] = 1;
            } else {
                matrix[slot.getPositionX()][slot.getPositionY()] = 0;
            }
        }
        return matrix;
    }

    /**
     * @return int[][]
     *
     * Metodo que se utiliza para calcular las ocurrencias de casilleros
     * contiguos
     */
    private int[][][] createSearchMatrix() {
        int[][][] matrix = new int[this.getWidth() + 2][this.getHeight() + 2][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k < 4; k++) {
                    matrix[i][j][k] = 0;
                }
            }
        }
        return matrix;
    }

    /**
     * @return boolean
     * @param int[][]
     * @param int[][][]
     * 
     * Metodo privado que determina si un player tiene una linea formada en
     * alguna de las posibles direcciones
     */
    private boolean search(int[][] boardMatrix, int[][][] searchMatrix) {
        boolean result = false;
        for (int i = 1; i < boardMatrix.length - 1; i++) {
            for (int j = 1; j < boardMatrix[0].length - 1; j++) {
                if (boardMatrix[i][j] == 1) {
                    // Actualiza vertical
                    searchMatrix[i][j][0] = searchMatrix[i - 1][j][0] + 1;
                    if (searchMatrix[i][j][0] == Game.LINE_SIZE) {
                        result = true;
                        break;
                    }
                    // Actualiza horizontal
                    searchMatrix[i][j][1] = searchMatrix[i][j - 1][1] + 1;
                    if (searchMatrix[i][j][1] == Game.LINE_SIZE) {
                        result = true;
                        break;
                    }
                    // Actualiza diagonal decreciente
                    searchMatrix[i][j][2] = searchMatrix[i - 1][j - 1][2] + 1;
                    if (searchMatrix[i][j][2] == Game.LINE_SIZE) {
                        result = true;
                        break;
                    }
                    // Actualiza diagonal creciente
                    searchMatrix[i][j][3] = searchMatrix[i - 1][j + 1][3] + 1;
                    if (searchMatrix[i][j][3] == Game.LINE_SIZE) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param oldSlot
     * @param newSlot
     *
     * Metodo que cambia la posicion de un casillero a otro vacio para un
     * Jugador determinado
     */
    public void changeSlot(Slot oldSlot, Slot newSlot) throws SlotFullException, SlotEmptyException {
        if (newSlot.getOwner() != null) {
            throw new SlotFullException();
        }
        if (oldSlot.getOwner() == null) {
            throw new SlotEmptyException();
        }
        newSlot.setOwner(oldSlot.getOwner());
        oldSlot.setOwner(null);
    }

    /**
     * @param slot
     *
     * Metodo que deja vacio un slot
     */
    public void emptySlot(Slot slot) throws SlotEmptyException {
        if (slot.getOwner() == null) {
            throw new SlotEmptyException();
        } else {
            slot.setOwner(null);
        }
    }

    /**
     * @param slot
     * @param player
     *
     * Metodo que asigna un casillero vacio a un Jugador determinado
     */
    public void obtainSlot(Player player, Slot slot) throws SlotFullException {
        if (slot.getOwner() != null) {
            throw new SlotFullException();
        } else {
            slot.setOwner(player);
        }
    }
}
