package service;

import dto.GameDTO;
import dto.PlayerDTO;
import dto.QuestionDTO;
import dto.SituationCardDTO;
import exception.PlayerNullException;
import java.util.ArrayList;
import java.util.List;
import model.Player;
import model.Question;
import model.SituationCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlayerRepository;

/**
 *
 * @author renzobelve
 *
 * Clase de servicio para funcionalidades de Game
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private QuestionService questionService;
    
    @Autowired
    private SituationCardService situationCardService;

    /**
     * @param id
     * @return playerDTO
     * @throws exception.PlayerNullException
     *
     * Metodo para la recuperacion de un player
     */
    public PlayerDTO findOneById(Long id) throws PlayerNullException {
        // Se busca el player
        Player player = this.playerRepository.findOne(id);
        // Si el player no existe se lanza una excepcion
        if (player == null) {
            throw new PlayerNullException();
        } else {
            return this.convertToPlayerDTO(player);
        }

    }

    /**
     * @param player
     * @return PlayerDTO
     *
     * Metodo para la creacion de un PlayerDTO a traves de un objeto Player
     */
    protected PlayerDTO convertToPlayerDTO(Player player) {
        if (player != null) {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            
            if (player.getActualGame() != null) {
                GameDTO gameDTO = new GameDTO();
                gameDTO.setId(player.getActualGame().getId());
                playerDTO.setActualGame(gameDTO);
            }
            playerDTO.setChallengeQuestion(this.questionService.convertToQuestionDTO(player.getChallengeQuestion()));
            List<QuestionDTO> questions = new ArrayList<>();
            for(Question question : player.getQuestions()){
                questions.add(this.questionService.convertToQuestionDTO(question));
            }
            playerDTO.setQuestions(questions);
            List<SituationCardDTO> situationCards = new ArrayList<>();
            for(SituationCard situationCard : player.getSituationCards()){
                situationCards.add(this.situationCardService.convertToSituationCardDTO(situationCard));
            }
            playerDTO.setSituationCards(situationCards);
            return playerDTO;
        } else {
            return null;
        }
    }

}
