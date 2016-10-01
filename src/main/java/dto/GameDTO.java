package dto;

import java.util.List;

/**
 *
 * @author renzobelve
 * 
 * Clase para transferencia de datos de Game
 */
public class GameDTO {
    
    private Long id;
    private int playerAmount;
    private List<PlayerDTO> players;
    private PlayerDTO activePlayer;

    /**
     * @return the playerAmount
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
     * @return the players
     */
    public List<PlayerDTO> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    /**
     * @return the activePlayer
     */
    public PlayerDTO getActivePlayer() {
        return activePlayer;
    }

    /**
     * @param activePlayer the activePlayer to set
     */
    public void setActivePlayer(PlayerDTO activePlayer) {
        this.activePlayer = activePlayer;
    }
}
