package pro.sky.secondcoursework.services;

import pro.sky.secondcoursework.domain.Question;

public interface QuestionService{
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);
}
