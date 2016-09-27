package loader;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        
        Player player1 = new Player("Jugador 1"); 
        this.playerRepository.save(player1);
        
    }
}
