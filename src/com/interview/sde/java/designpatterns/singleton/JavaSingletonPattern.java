package com.interview.sde.java.designpatterns.singleton;

//https://www.hackerrank.com/challenges/java-singleton/problem
public class JavaSingletonPattern {
    String str;
    private static JavaSingletonPattern singleton;

    private JavaSingletonPattern() {
    }

    static JavaSingletonPattern getSingleInstance() {
        if (singleton == null) {
            singleton = new JavaSingletonPattern();
        }
        return singleton;
    }
}
