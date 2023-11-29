package com.ll.sbbmission.question.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="제목은 필수 항목입니다.")
    @Size
    private String subject;

    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String content;
}
