package com.interview.sde.oop.servlet.translator;

public interface TranslatorAbstractFactory<T> {

    TranslatorFromT<T> createTranslatorFromT();

    TranslatorToResponse<T> createTranslatorToResponse();

}
