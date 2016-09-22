package model;

/**
 *
 * @author Renzo Belvedere
 * 
 * Clase que representa un Casillero en el Tablero
 */
class Slot {
    
    private int positionX;
    private int positionY;
    private Player owner;

    
    // Constructors ----------------------------
    public Slot(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.owner = null;
    }
    
    // Getters & Setters ----------------------------
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
    
}
