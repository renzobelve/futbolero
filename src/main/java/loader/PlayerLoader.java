package loader;

import exception.GameEmptyException;
import exception.GameFullException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Game;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import repository.GameRepository;
import repository.PlayerRepository;

/**
 *
 * @author renzobelve
 * 
 * Clase loader fixture para Game
 */
@Component
public class PlayerLoader implements ApplicationListener<ContextRefreshedEvent>{
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private GameRepository gameRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        
        Player player1 = new Player("Jugador 1");
        Game game = this.gameRepository.findOne((long) 1);
        
        try {
            game.addPlayer(player1);
        } catch (GameFullException | GameEmptyException ex) {
            Logger.getLogger(PlayerLoader.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        this.playerRepository.save(player1);
        this.gameRepository.save(game);
        
    }
}
