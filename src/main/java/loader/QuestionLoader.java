package loader;

import exception.QuestionMalformedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import repository.QuestionRepository;

/**
 *
 * @author renzobelve
 *
 * Clase loader fixture para Game
 */
@Component
public class QuestionLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        for (int i = 0; i < 100; i++) {
            String questionString1 = "¿Pregunta " + i + " ?";
            Answer answer1 = new Answer("Respuesta " + i + " 1", false);
            Answer answer2 = new Answer("Respuesta " + i + " 2", true);
            Answer answer3 = new Answer("Respuesta " + i + " 3", false);
            Answer answer4 = new Answer("Respuesta " + i + " 4", false);
            ArrayList<Answer> answers1 = new ArrayList<>();
            answers1.add(answer1);
            answers1.add(answer2);
            answers1.add(answer3);
            answers1.add(answer4);
            try {
                Question question = new Question(questionString1, answers1);
                this.questionRepository.save(question);
            } catch (QuestionMalformedException ex) {
                Logger.getLogger(QuestionLoader.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
        }

    }
}
