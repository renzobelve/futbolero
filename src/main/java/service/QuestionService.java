package service;

import dto.AnswerDTO;
import dto.QuestionDTO;
import exception.QuestionMalformedException;
import exception.QuestionNullException;
import java.util.ArrayList;
import java.util.List;
import model.Answer;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.QuestionRepository;

/**
 *
 * @author renzobelve
 *
 * Clase de servicio para funcionalidades de Question
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * @param questionDTO
     * @return QuestionDTO
     * @throws exception.QuestionMalformedException
     *
     * Metodo para la creacion de una nueva pregunta con sus respuestas
     */
    @Transactional
    public QuestionDTO createQuestion(QuestionDTO questionDTO) throws QuestionMalformedException {
        // Se crea la lista de respuestas
        List<Answer> answers = new ArrayList<>();
        for (AnswerDTO answerDTO : questionDTO.getAnswers()) {
            Answer answer = this.createAnswer(answerDTO);
            answers.add(answer);
        }
        // Se crea la pregunta
        Question question = new Question(questionDTO.getQuestion(), answers);
        // Se persiste la pregunta creada
        this.questionRepository.save(question);

        return this.convertToQuestionDTO(question);
    }

    /**
     * @param id
     * @return QuestionDTO
     * @throws exception.QuestionNullException
     *
     * Metodo para la recuperacion de una pregunta
     */
    public QuestionDTO findOneById(Long id) throws QuestionNullException {
        // Se busca la pregunta
        Question question = this.questionRepository.findOne(id);
        // Si la pregunta no existe se lanza una excepcion
        if (question == null) {
            throw new QuestionNullException();
        } else {
            return this.convertToQuestionDTO(question);
        }
    }

    /**
     * @return List
     *
     * Metodo para la recuperacion de todas las preguntas
     */
    public List<QuestionDTO> findAll() {
        List<QuestionDTO> questionsDTO = new ArrayList<>();
        // Se buscan todas las preguntas
        List<Question> questions = (List<Question>) this.questionRepository.findAll();
        for (Question question : questions) {
            questionsDTO.add(this.convertToQuestionDTO(question));
        }

        return questionsDTO;
    }

    /**
     * @param questionDTO
     * @return QuestionDTO
     * @throws exception.QuestionNullException
     *
     * Metodo para la modificacion de una pregunta con sus respuestas
     */
    @Transactional
    public QuestionDTO editQuestion(QuestionDTO questionDTO) throws QuestionNullException {
        // Se busca la pregunta
        Question question = this.questionRepository.findOne(questionDTO.getId());
        // Si la pregunta no existe se lanza una excepcion
        if (question == null) {
            throw new QuestionNullException();
        } else {
            // Se modifica la pregunta con el questionDTO
            question.setQuestion(questionDTO.getQuestion());
            question.setAnswerTime(questionDTO.getAnswerTime());
            List<Answer> answers = new ArrayList<>();
            for (AnswerDTO answerDTO : questionDTO.getAnswers()) {
                answers.add(this.createAnswer(answerDTO));
            }
            question.setAnswers(answers);

            // Se persiste la pregunta modificada
            this.questionRepository.save(question);
            return this.convertToQuestionDTO(question);
        }
    }

    /**
     * @param questionDTO
     * @throws exception.QuestionNullException
     *
     * Metodo para la eliminacion de una pregunta con sus respuestas
     */
    @Transactional
    public void deleteQuestion(QuestionDTO questionDTO) throws QuestionNullException {
        // Se busca la pregunta
        Question question = this.questionRepository.findOne(questionDTO.getId());
        // Si la pregunta no existe se lanza una excepcion
        if (question == null) {
            throw new QuestionNullException();
        } else {
            this.questionRepository.delete(question);
        }
    }

    /**
     * @param answerDTO
     * @return Answer
     *
     * Metodo para la creacion de una nueva respuesta
     */
    private Answer createAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer(answerDTO.getAnswer(), answerDTO.isIsCorrect());
        return answer;
    }

    /**
     * @param question
     * @return QuestionDTO
     *
     * Metodo para la creacion de un QuestionDTO a traves de un objeto Question
     */
    public QuestionDTO convertToQuestionDTO(Question question) {
        if (question != null) {
            List<AnswerDTO> answers = new ArrayList<>();
            for (Answer answer : question.getAnswers()) {
                AnswerDTO answerDTO = new AnswerDTO();
                answerDTO.setId(answer.getId());
                answerDTO.setAnswer(answer.getAnswer());
                answerDTO.setIsCorrect(answer.isIsCorrect());
                answers.add(answerDTO);
            }
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setQuestion(question.getQuestion());
            questionDTO.setAnswerTime(question.getAnswerTime());
            questionDTO.setAnswers(answers);

            return questionDTO;
        } else {
            return null;
        }
    }

}
