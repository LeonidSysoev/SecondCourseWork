package pro.sky.secondcoursework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.secondcoursework.domain.Question;
import pro.sky.secondcoursework.services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount:\\d+}")
    public Collection<Question> getRandomQuestion(@PathVariable (name = "amount") int amount){
        return examinerService.getQuestions(amount);
    }
}
