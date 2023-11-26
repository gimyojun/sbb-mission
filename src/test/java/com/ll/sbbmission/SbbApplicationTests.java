package com.ll.sbbmission;

import com.ll.sbbmission.answer.repository.AnswerRepository;
import com.ll.sbbmission.question.entity.Question;
import com.ll.sbbmission.question.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;


    @Test()
    void testJpa(){
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고싶습니다");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);
    }
    @Test
    @DisplayName("jpa 테스트 1")
    void testJpa1() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(1, all.size());
    }

//    @Test
//    @DisplayName("jpa 테스트 2")
//    void testJpa2(){
//        Optional<Question> oq = questionRepository.findById(1);
//        if(oq.isPresent()){
//            Question question = oq.get();
//            assertEquals("sbb가 무엇인가요?", question.getSubject());
//        }
//    }
//    @Test
//    @DisplayName("jpa 테스트 3")
//    void testJpa3(){
//        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//        assertEquals(1,q.getId());
//    }
//    @Test
//    @DisplayName("jpa 테스트 4")
//    void testJpa4(){
//        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?","sbb에 대해서 알고싶습니다");
//
//        assertEquals(1,q.getId());
//    }
//    @Test
//    @DisplayName("jpa 테스트 5")
//    void testJpa5(){
//        List<Question> q = this.questionRepository.findBySubjectLike("sbb%");
//        Question tmp = q.get(0);
//        assertEquals(1,tmp.getId());
//    }
//    @Test
//    @DisplayName("jpa 테스트 6")
//    void testJpa6(){
//        Optional<Question> oq = this.questionRepository.findById(1);
//        Question q = oq.get();
//        q.setSubject("sbb 수정된 제목");
//        this.questionRepository.save(q);
//        assertEquals("sbb 수정된 제목", q.getSubject());
//
//    }
//    @Test
//    @DisplayName("jpa 테스트 7")
//    void testJpa7(){
//        Optional<Question> oq = this.questionRepository.findById(2);
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
//
//    }
//    @Test
//    @DisplayName("jpa 테스트 8")
//    void testJpa8() {
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);
//    }
//
//    @Test
//    @DisplayName("jpa 테스트 9")
//    void testJpa9() {
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answerList = q.getAnswerList();
//        assertEquals(1, answerList.size());
//        assertEquals("네 자동으로 생성됩니다.",answerList.get(0).getContent());
//    }
}
