package loader;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.SituationCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import repository.SituationCardRepository;

/**
 *
 * @author renzobelve
 *
 * Clase loader fixture para Game
 */
@Component
public class SituationCardLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SituationCardRepository situationCardRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        
        SituationCard warningSituation = new SituationCard("AMONESTACION", "Permite cambiar la posicion de la pelota de un casillero a otro vacio");
        this.situationCardRepository.save(warningSituation);
        
        SituationCard expulsionSituation = new SituationCard("EXPULSION", "Permite eliminar una pelota de cualquier casillero");
        this.situationCardRepository.save(expulsionSituation);
        
        SituationCard changeSituation = new SituationCard("CAMBIO", "Permite cambiar la pregunta realizada por el retador");
        this.situationCardRepository.save(changeSituation);
        
        SituationCard offsideSituation = new SituationCard("OFFSIDE", "Permite declarar nula a una pregunta contestada correctamente por algun jugador obligandolo a recomenzar su turno");
        this.situationCardRepository.save(offsideSituation);
        
        SituationCard freekickSituation = new SituationCard("TIRO LIBRE", "Permite reducir a 3 las opciones de respuesta de una pregunta");
        this.situationCardRepository.save(freekickSituation);
        
        SituationCard penaltySituation = new SituationCard("PENAL", "Permite reducir a 2 las opciones de respuesta de una pregunta");
        this.situationCardRepository.save(penaltySituation);
        
        SituationCard injurySituation = new SituationCard("LESION", "Permite hacer perder un turno a un jugador");
        this.situationCardRepository.save(injurySituation);
        
        SituationCard timeoffSituation = new SituationCard("TIEMPO DE DESCUENTO", "Permite reducir el tiempo de pregunta para un jugador");
        this.situationCardRepository.save(timeoffSituation);
    }
}
