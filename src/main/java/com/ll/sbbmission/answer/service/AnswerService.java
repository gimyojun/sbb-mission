package com.ll.sbbmission.answer.service;

import com.ll.sbbmission.answer.entity.Answer;
import com.ll.sbbmission.answer.repository.AnswerRepository;
import com.ll.sbbmission.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    public List<Answer> getList() {
        return this.answerRepository.findAll();
    }
    public void create(Question question, String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }

}
