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
    private PlayerDTO winner;
    private boolean isOpen;

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

    /**
     * @return the winner
     */
    public PlayerDTO getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(PlayerDTO winner) {
        this.winner = winner;
    }

    /**
     * @return the isOpen
     */
    public boolean isIsOpen() {
        return isOpen;
    }

    /**
     * @param isOpen the isOpen to set
     */
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
