package pro.sky.secondcoursework.services;

import org.junit.jupiter.api.Test;
import pro.sky.secondcoursework.domain.Question;
import pro.sky.secondcoursework.exceptions.QuestionAlreadyAddedException;
import pro.sky.secondcoursework.exceptions.QuestionNotCorrectException;
import pro.sky.secondcoursework.exceptions.QuestionNotFoundException;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    QuestionService questionService = new JavaQuestionService();


    @Test
    void addTest() {
        Question expected = questionService.add("question1", "answer1");
        Question actual = new Question("question1", "answer1");
        assertEquals(expected, actual);

    }

    @Test
    void questionAlreadyAddedExceptionTest() {
        questionService.add("question1", "answer1");
        assertThrows(QuestionAlreadyAddedException.class,
                () -> questionService.add("question1", "answer1"));
    }


    @Test
    void findTest() {
        Question actual = new Question("question1", "answer1");
        Question question = questionService.add("question1", "answer1");
        Question expected = questionService.find(question);
        assertEquals(expected, actual);
    }
    @Test
    void questionNotFoundExceptionTest() {
        questionService.add("question1", "answer1");
        Question question = new Question("question2", "answer2");
        assertThrows(QuestionNotFoundException.class,
                () -> questionService.find(question));
    }

    @Test
    void questionNotCorrectExceptionTest() {
        assertThrows(QuestionNotCorrectException.class,
                () -> questionService.add("%%%", "$$$$"));
    }


    @Test
    void getAllTest() {
        questionService.add("question1", "answer1");
        questionService.add("question2", "answer2");
        questionService.add("question3", "answer3");
        Collection<Question> actual = questionService.getAll();
        assertEquals(3, actual.size());
    }

    @Test
    void getRandomQuestionTest() {
        questionService.add("question1", "answer1");
        questionService.add("question2", "answer2");
        assertNotNull(questionService.getRandomQuestion());
    }
}