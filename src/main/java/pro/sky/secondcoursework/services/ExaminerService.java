package pro.sky.secondcoursework.services;

import pro.sky.secondcoursework.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
