package pro.sky.secondcoursework.services;

import org.assertj.core.error.AnyElementShouldMatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.secondcoursework.domain.Question;
import pro.sky.secondcoursework.exceptions.NumbersElementNotCorrectException;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {


    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    private ExaminerServiceImpl service;
    @BeforeEach
    void initService() {
        service = new ExaminerServiceImpl(javaQuestionServiceMock);
    }


    @Test
    void getQuestionsTest() {
        Set<Question> questions = Set.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(
                        new Question("question1", "answer1"),
                        new Question("question2", "answer2"));
        var actual = service.getQuestions(2);
        assertEquals(2, actual.size());
        verify(javaQuestionServiceMock,times(2)).getRandomQuestion();
    }
    @Test
    void numbersElementNotCorrectExceptionTest() {
        Set<Question> questions = Set.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        assertThrows(NumbersElementNotCorrectException.class, () -> service.getQuestions(4));
    }

}
