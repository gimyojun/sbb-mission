package com.ll.sbbmission;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloLombok {
    private final String hello;
    private final int num;

    public static void main(String[] args) {
        HelloLombok app = new HelloLombok("hello lombok @RequiredArgsConstructor", 10);

        System.out.println(app.getHello());
        System.out.println(app.getNum());

    }
}
