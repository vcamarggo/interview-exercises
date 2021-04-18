package com.interview.sde.mock.servlet.translator;

public interface TranslatorToResponse<T> {
    String translateToResponse(T t);
}
