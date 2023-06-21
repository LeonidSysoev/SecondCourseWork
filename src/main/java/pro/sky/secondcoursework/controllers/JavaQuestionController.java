package pro.sky.secondcoursework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.secondcoursework.domain.Question;
import pro.sky.secondcoursework.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")

public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/find")
    Question findQuestion(@RequestParam String question, @RequestParam String answer) {
        Question findQuestion = new Question(question, answer);
        return questionService.find(findQuestion);
    }

    @GetMapping("/remove")
    Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question removeQuestion = new Question(question, answer);
        return questionService.remove(removeQuestion);
    }
    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}
