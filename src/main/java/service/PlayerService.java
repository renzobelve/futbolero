package service;

import dto.GameDTO;
import dto.PlayerDTO;
import dto.QuestionDTO;
import dto.SituationCardDTO;
import dto.SlotDTO;
import exception.ChallengerNullException;
import exception.PlayerNullException;
import exception.QuestionNullException;
import java.util.ArrayList;
import java.util.List;
import model.Player;
import model.Question;
import model.SituationCard;
import model.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.PlayerRepository;
import repository.QuestionRepository;

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
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SituationCardService situationCardService;

    @Autowired
    private BoardService boardService;

    /**
     * @param playerDTO
     * @return PlayerDTO
     *
     * Metodo para la creacion de un nuevo Player
     */
    @Transactional
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        // Se crea el nuevo player
        Player player = new Player(playerDTO.getName());
        // Se periste el player creado
        this.playerRepository.save(player);

        return this.convertToPlayerDTO(player);
    }

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
     * @return List
     *
     * Metodo para la recuperacion de todas los players
     */
    public List<PlayerDTO> findAll() {
        List<PlayerDTO> playersDTO = new ArrayList<>();
        // Se buscan todas los players
        List<Player> players = (List<Player>) this.playerRepository.findAll();
        for (Player player : players) {
            playersDTO.add(this.convertToPlayerDTO(player));
        }
        return playersDTO;
    }
    
    /**
     * @param playerDTO
     * @param questionDTO
     * @return List
     * @throws exception.PlayerNullException
     * @throws exception.QuestionNullException
     * @throws exception.ChallengerNullException
     * 
     * Metodo que selecciona una pregunta disponible y la setea como
     * challengeQuestion del jugador retado
     */
    @Transactional
    public PlayerDTO selectQuestion(PlayerDTO playerDTO, QuestionDTO questionDTO) throws PlayerNullException, QuestionNullException, ChallengerNullException{
        // Se busca el player
        Player player = this.playerRepository.findOne(playerDTO.getId());
        // Se busca la pregunta
        Question question = this.questionRepository.findOne(questionDTO.getId());
        // Si el player no existe se lanza una excepcion
        if(player == null){
            throw new PlayerNullException();
        }
        // Si la pregunta no existe se lanza una excepcion
        if(question == null){
            throw new QuestionNullException();
        }
        player.selectQuestion(question);
        this.playerRepository.save(player);
        
        return this.convertToPlayerDTO(player);
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
            if (player.getChallengeQuestion() != null) {
                playerDTO.setChallengeQuestion(this.questionService.convertToQuestionDTO(player.getChallengeQuestion()));
            }
            if (!player.getQuestions().isEmpty()) {
                List<QuestionDTO> questions = new ArrayList<>();
                for (Question question : player.getQuestions()) {
                    questions.add(this.questionService.convertToQuestionDTO(question));
                }
                playerDTO.setQuestions(questions);
            }
            if (!player.getSituationCards().isEmpty()) {
                List<SituationCardDTO> situationCards = new ArrayList<>();
                for (SituationCard situationCard : player.getSituationCards()) {
                    situationCards.add(this.situationCardService.convertToSituationCardDTO(situationCard));
                }
                playerDTO.setSituationCards(situationCards);
            }
            if (!player.getSlots().isEmpty()) {
                List<SlotDTO> slots = new ArrayList<>();
                for (Slot slot : player.getSlots()) {
                    slots.add(this.boardService.convertToSlotDTO(slot));
                }
                playerDTO.setSlots(slots);
            }
            if (player.getChallenger() != null) {
                PlayerDTO challenger = this.convertToPlayerDTO(player.getChallenger());
                playerDTO.setChallenger(challenger);
            }
            playerDTO.setCountWarnings(player.getCountWarnings());
            playerDTO.setCountExpulsions(player.getCountExpulsions());
            playerDTO.setIsOffside(player.isIsOffside());
            playerDTO.setHasChange(player.isHasChange());
            playerDTO.setCountAnswers(player.getCountAnswers());
            playerDTO.setAnswerTime(player.getAnswerTime());
            playerDTO.setHasNextTurn(player.isHasNextTurn());
            playerDTO.setHasToDrawQuestion(player.isHasToDrawQuestion());

            return playerDTO;
        } else {
            return null;
        }
    }

}
