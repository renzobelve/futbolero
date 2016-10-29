package dto;

/**
 *
 * @author renzobelve
 * 
 * Clase para transferencia de datos de Slot
 */
public class SlotDTO {
    
    private Long id;
    private int positionX;
    private int positionY;

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
}
