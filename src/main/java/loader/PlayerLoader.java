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
        this.playerRepository.save(player1);
        
    }
}
