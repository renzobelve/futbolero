package service;

import dto.SituationCardDTO;
import exception.SituationCardNullException;
import java.util.ArrayList;
import java.util.List;
import model.SituationCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.SituationCardRepository;

/**
 *
 * @author renzobelve
 *
 * Clase de servicio para funcionalidades de SituationCard
 */
@Service
public class SituationCardService {

    @Autowired
    private SituationCardRepository situationCardRepository;

    /**
     * @param situationCardDTO
     * @return SituationCardDTO
     *
     * Metodo para la creacion de una nueva SituationCard
     */
    @Transactional
    public SituationCardDTO createSituationCard(SituationCardDTO situationCardDTO) {
        // Se crea la situacion
        SituationCard situationCard = new SituationCard(situationCardDTO.getName(), situationCardDTO.getDescription());
        // Se periste la situacion creada
        this.situationCardRepository.save(situationCard);
        
        return this.convertToSituationCardDTO(situationCard);
    }
    
    /**
     * @param id
     * @return SituationCardDTO
     * @throws exception.SituationCardNullException
     *
     * Metodo para la recuperacion de una situacion
     */
    public SituationCardDTO findOneById(Long id) throws SituationCardNullException{
        // Se busca la situacion
        SituationCard situationCard = this.situationCardRepository.findOne(id);
        // Si la situacion no existe se lanza una excepcion
        if(situationCard == null){
            throw new SituationCardNullException();
        }else{
            return this.convertToSituationCardDTO(situationCard);
        }
    }
    
    /**
     * @return List
     *
     * Metodo para la recuperacion de todas las situaciones
     */
    public List<SituationCardDTO> findAll(){
        List<SituationCardDTO> situationsDTO = new ArrayList<>();
        // Se buscan todas las situaciones
        List<SituationCard> situations = (List<SituationCard>) this.situationCardRepository.findAll();
        for(SituationCard situationCard : situations){
            situationsDTO.add(this.convertToSituationCardDTO(situationCard));
        }
        return situationsDTO;
    }
    
    /**
     * @param situationCardDTO
     * @return SituationCardDTO
     * @throws exception.SituationCardNullException
     *
     * Metodo para la modificacion de una situacion
     */
    @Transactional
    public SituationCardDTO editSituationCard(SituationCardDTO situationCardDTO) throws SituationCardNullException {
        // Se busca la situacion
        SituationCard situationCard = this.situationCardRepository.findOne(situationCardDTO.getId());
        // Si la situacion no existe se lanza una excepcion
        if (situationCard == null) {
            throw new SituationCardNullException();
        } else {
            // Se modifica la situacion con el situationDTO
            situationCard.setName(situationCardDTO.getName());
            situationCard.setDescription(situationCardDTO.getDescription());

            // Se persiste la situacion modificada
            this.situationCardRepository.save(situationCard);
            return this.convertToSituationCardDTO(situationCard);
        }
    }
    
    /**
     * @param situationCardDTO
     * @throws exception.SituationCardNullException
     *
     * Metodo para la eliminacion de una situacion
     */
    @Transactional
    public void deleteSituationCard(SituationCardDTO situationCardDTO) throws SituationCardNullException {
        // Se busca la situacion
        SituationCard situation = this.situationCardRepository.findOne(situationCardDTO.getId());
        // Si la situacion no existe se lanza una excepcion
        if (situation == null) {
            throw new SituationCardNullException();
        } else {
            this.situationCardRepository.delete(situation);
        }
    }

    /**
     * @param situationCard
     * @return SituationCardDTO
     *
     * Metodo para la creacion de un SituationCardDTO a traves de un objeto SituationCard
     */
    public SituationCardDTO convertToSituationCardDTO(SituationCard situationCard) {
        if(situationCard != null){
            SituationCardDTO situationCardDTO = new SituationCardDTO();
            situationCardDTO.setId(situationCard.getId());
            situationCardDTO.setName(situationCard.getName());
            situationCardDTO.setDescription(situationCard.getDescription());
            
            return situationCardDTO;
        }else{
            return null;
        }
    }
}
