package com.ll.sbbmission.question.controller;

import com.ll.sbbmission.answer.form.AnswerForm;
import com.ll.sbbmission.question.entity.Question;
import com.ll.sbbmission.question.form.QuestionForm;
import com.ll.sbbmission.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question/detail";
    }
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "/question/questionform";
    }
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "question/questionform";

        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }

}
