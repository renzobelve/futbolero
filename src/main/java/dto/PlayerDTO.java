package dto;

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
    
}
