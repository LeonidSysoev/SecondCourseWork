package pro.sky.secondcoursework.services;

import org.springframework.stereotype.Service;
import pro.sky.secondcoursework.domain.Question;
import pro.sky.secondcoursework.exceptions.NumbersElementNotCorrectException;

import java.util.*;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionList = new HashSet<>(amount);
        if (amount > questionService.getAll().size()) {
            throw new NumbersElementNotCorrectException();
        }
        for (int i = 0; i < amount; i++) {
            questionList.add(questionService.getRandomQuestion());
        }
        return questionList;

    }
}
