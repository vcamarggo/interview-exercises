package com.interview.sde.mock.servlet.translator;

public interface TranslatorAbstractFactory<T> {

    TranslatorFromT<T> createTranslatorFromT();
    TranslatorToResponse<T> createTranslatorToResponse();

}
