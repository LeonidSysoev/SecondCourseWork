package pro.sky.secondcoursework.services;

import org.springframework.stereotype.Service;
import pro.sky.secondcoursework.domain.Question;
import pro.sky.secondcoursework.exceptions.QuestionAlreadyAddedException;
import pro.sky.secondcoursework.exceptions.QuestionNotCorrectException;
import pro.sky.secondcoursework.exceptions.QuestionNotFoundException;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {

    private Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        checkValidation(question, answer);
        Question newQuestion = new Question(question, answer);
        if (questions.contains(newQuestion)) {
            throw new QuestionAlreadyAddedException();
        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question find(Question question) {
        checkValidation(question.getQuestion(), question.getAnswer());
        if (questions.contains(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Question remove(Question question) {
        checkValidation(question.getQuestion(), question.getAnswer());
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(questions);
        int randomIndex = new Random().nextInt(questionList.size());
        return questionList.get(randomIndex);
    }

    private void checkValidation(String question, String answer) {
        if (!question.matches("^[а-яА-Яa-zA-Z0-9!?]+$") || !answer.matches("^[а-яА-Яa-zA-Z0-9!?]+$")) {
            throw new QuestionNotCorrectException();
        }

    }

}
