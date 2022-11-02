package com.interview.sde.java.oop.servlet.translator;

public interface TranslatorAbstractFactory<T> {

    TranslatorFromT<T> createTranslatorFromT();

    TranslatorToResponse<T> createTranslatorToResponse();

}
