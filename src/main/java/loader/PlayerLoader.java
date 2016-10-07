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
        Player player2 = new Player("Jugador 2"); 
        this.playerRepository.save(player2);
        Player player3 = new Player("Jugador 3"); 
        this.playerRepository.save(player3);
        Player player4 = new Player("Jugador 4"); 
        this.playerRepository.save(player4);
        Player player5 = new Player("Jugador 5"); 
        this.playerRepository.save(player5);
        Player player6 = new Player("Jugador 6"); 
        this.playerRepository.save(player6);
        Player player7 = new Player("Jugador 7"); 
        this.playerRepository.save(player7);
        Player player8 = new Player("Jugador 8"); 
        this.playerRepository.save(player8);
        
    }
}
