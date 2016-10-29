package service;

import app.Application;
import dto.SituationCardDTO;
import exception.SituationCardNullException;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

/**
 *
 * @author renzobelve
 *
 * Clase que testea actividades y funcionamiento de QuestionService
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class SituationCardServiceTest {

    @Autowired
    private SituationCardService situationCardService;

    @Test
    public void testCreateSituationCard() {

        SituationCardDTO situationCardDTO = new SituationCardDTO();
        situationCardDTO.setName("PRUEBA");
        situationCardDTO.setDescription("Permite cambiar la posicion de la pelota de un casillero a otro vacio");

        try {
            SituationCardDTO newSituationCardDTO = this.situationCardService.createSituationCard(situationCardDTO);
            Assert.assertNotNull(newSituationCardDTO.getId());
            newSituationCardDTO = this.situationCardService.findOneById(newSituationCardDTO.getId());
            Assert.assertEquals("PRUEBA", newSituationCardDTO.getName());
        } catch (SituationCardNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testFindAllSituations() {
        List<SituationCardDTO> situations = this.situationCardService.findAll();
        Assert.assertEquals(8, situations.size());
    }

    @Test
    public void testEditSituationCard() {    
        try {
            SituationCardDTO originalSituation = this.situationCardService.findOneById((long) 578);
            String nameString = originalSituation.getName();
            originalSituation.setName("Situacion Modificada");
            SituationCardDTO modifiedSituation = this.situationCardService.editSituationCard(originalSituation);
            String nameModifiedString = modifiedSituation.getName();
            Assert.assertNotEquals(nameString, nameModifiedString);
        } catch (SituationCardNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testDeleteSituationCard() {    
        try {
            SituationCardDTO situationCardDTO = this.situationCardService.findOneById((long) 577);
            List<SituationCardDTO> situationsCardDTO = this.situationCardService.findAll();
            Assert.assertEquals(8, situationsCardDTO.size());
            this.situationCardService.deleteSituationCard(situationCardDTO);
            situationsCardDTO = this.situationCardService.findAll();
            Assert.assertEquals(7, situationsCardDTO.size());
        } catch (SituationCardNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
}
