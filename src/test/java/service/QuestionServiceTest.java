package service;

import app.Application;
import dto.AnswerDTO;
import dto.QuestionDTO;
import exception.QuestionMalformedException;
import exception.QuestionNullException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author renzobelve
 *
 * Clase que testea actividades y funcionamiento de QuestionService
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class QuestionServiceTest {
    
    @Autowired
    private QuestionService questionService;
    
    @Test
    public void testCreateQuestion() {
        List<AnswerDTO> answers = new ArrayList();
        AnswerDTO answerDTO1 = new AnswerDTO();
        answerDTO1.setAnswer("Respuesta 1");
        answerDTO1.setIsCorrect(false);
        answers.add(answerDTO1);
        AnswerDTO answerDTO2 = new AnswerDTO();
        answerDTO2.setAnswer("Respuesta 2");
        answerDTO2.setIsCorrect(true);
        answers.add(answerDTO2);
        AnswerDTO answerDTO3 = new AnswerDTO();
        answerDTO3.setAnswer("Respuesta 3");
        answerDTO3.setIsCorrect(false);
        answers.add(answerDTO3);
        AnswerDTO answerDTO4 = new AnswerDTO();
        answerDTO4.setAnswer("Respuesta 4");
        answerDTO4.setIsCorrect(false);
        answers.add(answerDTO4);
        
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestion("¿Pregunta 1?");
        questionDTO.setAnswers(answers);
        
        try {
            QuestionDTO newQuestionDTO = this.questionService.createQuestion(questionDTO);
            Assert.assertNotNull(newQuestionDTO.getId());
            newQuestionDTO = this.questionService.findOneById(newQuestionDTO.getId());
            Assert.assertEquals(4, newQuestionDTO.getAnswers().size());
        } catch (QuestionMalformedException | QuestionNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testFindAllQuestions() { 
        List<QuestionDTO> questions = this.questionService.findAll();
        Assert.assertEquals(100, questions.size());
    
    }
    
    @Test
    public void testEditQuestion() {    
        try {
            QuestionDTO originalQuestion = this.questionService.findOneById((long) 71);
            String questionString = originalQuestion.getQuestion();
            String answerString = originalQuestion.getAnswers().get(0).getAnswer();
            originalQuestion.setQuestion("Pregunta modificada");
            originalQuestion.getAnswers().get(0).setAnswer("Respuesta modificada");
            QuestionDTO modifiedQuestion = this.questionService.editQuestion(originalQuestion);
            String questionModifiedString = modifiedQuestion.getQuestion();
            String answerModifiedString = modifiedQuestion.getAnswers().get(0).getAnswer();
            Assert.assertNotEquals(questionString, questionModifiedString);
            Assert.assertNotEquals(answerString, answerModifiedString);
        } catch (QuestionNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void testDeleteQuestion() {    
        try {
            QuestionDTO questionDTO = this.questionService.findOneById((long) 71);
            List<QuestionDTO> questionsDTO = this.questionService.findAll();
            Assert.assertEquals(101, questionsDTO.size());
            this.questionService.deleteQuestion(questionDTO);
            questionsDTO = this.questionService.findAll();
            Assert.assertEquals(100, questionsDTO.size());
        } catch (QuestionNullException ex) {
            Assert.fail(ex.getMessage());
        }
    }
}
