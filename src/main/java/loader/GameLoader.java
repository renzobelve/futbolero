package loader;

import model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import repository.GameRepository;

/**
 *
 * @author renzobelve
 * 
 * Clase loader fixture para Game
 */
@Component
public class GameLoader implements ApplicationListener<ContextRefreshedEvent>{
    
    @Autowired
    private GameRepository gameRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        
        Game game = new Game(4);
        this.gameRepository.save(game);
        
        Game game2 = new Game(4);
        this.gameRepository.save(game2);
    }
}
