package com.ll.sbbmission.answer.controller;

import com.ll.sbbmission.answer.service.AnswerService;
import com.ll.sbbmission.question.entity.Question;
import com.ll.sbbmission.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    @PostMapping("create/{id}")
    public String createAnswer(
            Model model,
            @PathVariable("id") Integer id,
            @RequestParam String content
            ) {
        Question question = this.questionService.getQuestion(id);
        answerService.create(question, content);

        return String.format("redirect:/question/detail/%s", id);
    }


}