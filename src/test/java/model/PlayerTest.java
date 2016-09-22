package model;

import exception.QuestionMalformedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author renzobelve
 *
 * Clase que testea actividades y funcionamiento de Player y PlayerState
 */
public class PlayerTest {

    private Player player1;
    private Player player2;

    @Before
    public void init() {
        this.player1 = new Player("Jugador 1");
        this.player2 = new Player("Jugador 2");

        String questionString1 = "¿Cuantas copas Libertadores tiene el club Estudiantes de La Plata?";
        Answer answer1 = new Answer("2", false);
        Answer answer2 = new Answer("3", true);
        Answer answer3 = new Answer("4", false);
        Answer answer4 = new Answer("5", false);
        ArrayList<Answer> answers1 = new ArrayList<>();
        answers1.add(answer1);
        answers1.add(answer2);
        answers1.add(answer3);
        answers1.add(answer4);
        try {
            this.player1.getQuestions().add(new Question(questionString1, answers1));
        } catch (QuestionMalformedException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testPlayTurn() {
        Assert.assertEquals(this.player1.getState().getClass(), WaitingState.class);
        this.player1.playTurn();
        Assert.assertEquals(this.player1.getState().getClass(), StartState.class);
    }

    @Test
    public void testSelectAndDrawQuestion() {
        // Select Question
        Assert.assertEquals(this.player1.getState().getClass(), WaitingState.class);
        Question question = this.player1.getQuestions().get(0);
        this.player2.playTurn();
        this.player2.selectAsChallanger(this.player1);
        this.player1.selectQuestion(question);
        Assert.assertNotNull(player2.getChallangeQuestion());
        Assert.assertEquals(0, this.player1.getQuestions().size());

        // Draw Question
        if (this.player1.isHasToDrawQuestion()) {
            Question question1 = null;
            Question question2 = null;
            Question question3 = null;
            Question question4 = null;
            String questionString1 = "¿Cuantas copas Libertadores tiene el club Estudiantes de La Plata?";
            Answer answer1 = new Answer("2", false);
            Answer answer2 = new Answer("3", true);
            Answer answer3 = new Answer("4", false);
            Answer answer4 = new Answer("5", false);
            ArrayList<Answer> answers1 = new ArrayList<>();
            answers1.add(answer1);
            answers1.add(answer2);
            answers1.add(answer3);
            answers1.add(answer4);
            try {
                question1 = new Question(questionString1, answers1);
            } catch (QuestionMalformedException ex) {
                Assert.fail(ex.getMessage());
            }
            String questionString2 = "¿Cuantas copas Libertadores tiene el club Estudiantes de La Plata?";
            Answer answer5 = new Answer("2", false);
            Answer answer6 = new Answer("3", true);
            Answer answer7 = new Answer("4", false);
            Answer answer8 = new Answer("5", false);
            ArrayList<Answer> answers2 = new ArrayList<>();
            answers2.add(answer5);
            answers2.add(answer6);
            answers2.add(answer7);
            answers2.add(answer8);
            try {
                question2 = new Question(questionString2, answers2);
            } catch (QuestionMalformedException ex) {
                Assert.fail(ex.getMessage());
            }
            String questionString3 = "¿Cuantas copas Libertadores tiene el club Estudiantes de La Plata?";
            Answer answer9 = new Answer("2", false);
            Answer answer10 = new Answer("3", true);
            Answer answer11 = new Answer("4", false);
            Answer answer12 = new Answer("5", false);
            ArrayList<Answer> answers3 = new ArrayList<>();
            answers3.add(answer9);
            answers3.add(answer10);
            answers3.add(answer11);
            answers3.add(answer12);
            try {
                question3 = new Question(questionString3, answers3);
            } catch (QuestionMalformedException ex) {
                Assert.fail(ex.getMessage());
            }
            String questionString4 = "¿Cuantas copas Libertadores tiene el club Estudiantes de La Plata?";
            Answer answer13 = new Answer("2", false);
            Answer answer14 = new Answer("3", true);
            Answer answer15 = new Answer("4", false);
            Answer answer16 = new Answer("5", false);
            ArrayList<Answer> answers4 = new ArrayList<>();
            answers4.add(answer13);
            answers4.add(answer14);
            answers4.add(answer15);
            answers4.add(answer16);
            try {
                question4 = new Question(questionString4, answers4);
            } catch (QuestionMalformedException ex) {
                Assert.fail(ex.getMessage());
            }

            ArrayList<Question> questions = new ArrayList<>();
            questions.add(question1);
            questions.add(question2);
            questions.add(question3);
            questions.add(question4);
            this.player1.drawQuestions(questions);
            Assert.assertEquals(4, this.player1.getQuestions().size());
        }
    }

    @Test
    public void testSelectChallenger() {
        this.player1.playTurn();
        Assert.assertEquals(this.player1.getState().getClass(), StartState.class);
        this.player1.selectAsChallanger(this.player2);
        Assert.assertEquals(this.player2.getChallanger(), this.player1);
        Assert.assertEquals(this.player1.getState().getClass(), AnswerState.class);
    }

    @Test
    public void testFinishTurn() {
        this.player1.playTurn();
        Assert.assertEquals(this.player1.getState().getClass(), StartState.class);
        this.player1.finishTurn();
        Assert.assertEquals(this.player1.getState().getClass(), EndState.class);
    }

    @Test
    public void testChangeQuestion() {
        String questionString1 = "¿Cuantas veces salio campeon mundial la seleccion Argentina?";
        Answer answer1 = new Answer("2", true);
        Answer answer2 = new Answer("3", false);
        Answer answer3 = new Answer("4", false);
        Answer answer4 = new Answer("5", false);
        ArrayList<Answer> answers1 = new ArrayList<>();
        answers1.add(answer1);
        answers1.add(answer2);
        answers1.add(answer3);
        answers1.add(answer4);
        try {
            this.player1.getQuestions().add(new Question(questionString1, answers1));
        } catch (QuestionMalformedException ex) {
            Assert.fail(ex.getMessage());
        }

        String questionString2 = "¿Quien fue el ultimo campeon mundial?";
        Answer answer5 = new Answer("Alemania", true);
        Answer answer6 = new Answer("Brasil", false);
        Answer answer7 = new Answer("Argentina", false);
        Answer answer8 = new Answer("Holanda", false);
        ArrayList<Answer> answers2 = new ArrayList<>();
        answers2.add(answer5);
        answers2.add(answer6);
        answers2.add(answer7);
        answers2.add(answer8);
        try {
            this.player1.getQuestions().add(new Question(questionString2, answers2));
        } catch (QuestionMalformedException ex) {
            Assert.fail(ex.getMessage());
        }

        this.player2.playTurn();
        Assert.assertEquals(this.player2.getState().getClass(), StartState.class);
        this.player2.selectAsChallanger(this.player1);
        this.player1.selectQuestion(this.player1.getQuestions().get(0));
        this.player2.changeQuestion();
        Assert.assertEquals(1, this.player1.getQuestions().size());
        Assert.assertNotEquals(this.player2.getChallangeQuestion(), this.player1.getQuestions().get(0));
    }

    @Test
    public void testAnswerQuestion() {
        this.player2.playTurn();
        Assert.assertEquals(this.player2.getState().getClass(), StartState.class);
        this.player2.selectAsChallanger(this.player1);
        this.player1.selectQuestion(this.player1.getQuestions().get(0));
        Assert.assertTrue(this.player2.answerQuestion(this.player2.getChallangeQuestion().getAnswers().get(1)));
        Assert.assertEquals(this.player2.getState().getClass(), BoardState.class);
    }

    @Test
    public void testChangeAnswerTime() {
        this.player2.setAnswerTime(10);
        this.player2.playTurn();
        Assert.assertEquals(this.player2.getState().getClass(), StartState.class);
        this.player2.selectAsChallanger(this.player1);
        this.player1.selectQuestion(this.player1.getQuestions().get(0));
        this.player2.changeAnswerTime();
        Assert.assertNotEquals(this.player2.getChallangeQuestion().getAnswerTime(), Question.QUESTION_TIME);
    }
}
