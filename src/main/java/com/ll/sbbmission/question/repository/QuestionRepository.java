package com.ll.sbbmission.question.repository;

import com.ll.sbbmission.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//레포지터리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입(Integer)을 지정
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    //레포티터리의 메서드 명은 데이터를 조회하는 쿼리문의 where 조건을 결정하는 역할을 한다.
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
}
