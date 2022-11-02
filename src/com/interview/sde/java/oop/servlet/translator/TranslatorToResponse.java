package com.interview.sde.oop.servlet.translator;

public interface TranslatorToResponse<T> {
    String translateToResponse(T t);
}
