package model;

import exception.QuestionMalformedException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author renzobelve
 * 
 * Clase que testea actividades y funcionamiento de Question y Answer
 */
public class QuestionTest {
    
    private Question question1;
    private Question question2;

    @Before
    public void init() {
        String questionString1 = "¿Cuantas copas Libertadores tiene el club Estudiantes de La Plata?";
        Answer answer1 = new Answer("2", false);
        Answer answer2 = new Answer("3", true);
        Answer answer3 = new Answer("4", false);
        Answer answer4 = new Answer("5", false);
        ArrayList<Answer> answers1= new ArrayList<>();
        answers1.add(answer1);
        answers1.add(answer2);
        answers1.add(answer3);
        answers1.add(answer4);
        try {
            this.question1 = new Question(questionString1, answers1);
        } catch (QuestionMalformedException ex) {
            Assert.fail(ex.getMessage());
        }
        
        String questionString2 = "¿Cuantas veces salio campeona del mundo la seleccion Argentina?";
        Answer answer5 = new Answer("1", false);
        Answer answer6 = new Answer("2", true);
        Answer answer7 = new Answer("3", false);
        Answer answer8 = new Answer("4", false);
        ArrayList<Answer> answers2= new ArrayList<>();
        answers2.add(answer5);
        answers2.add(answer6);
        answers2.add(answer7);
        answers2.add(answer8);
        try {
            this.question2 = new Question(questionString2, answers2);
        } catch (QuestionMalformedException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testCheckIsCorrect(){
        Answer answerIncorrect = this.question1.getAnswers().get(0);
        boolean result1 = this.question1.checkIsCorrect(answerIncorrect);
        Assert.assertFalse(result1);
        
        Answer answerCorrect = this.question1.getAnswers().get(1);
        boolean result2 = this.question1.checkIsCorrect(answerCorrect);
        Assert.assertTrue(result2);
    }
    
}
