package com.interview.sde.java.oop.servlet.translator;

public interface TranslatorToResponse<T> {
    String translateToResponse(T t);
}
