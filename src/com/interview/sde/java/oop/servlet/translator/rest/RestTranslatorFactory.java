package com.interview.sde.java.oop.servlet.translator.rest;

import com.interview.sde.java.oop.servlet.servlet.RestRequest;
import com.interview.sde.java.oop.servlet.translator.TranslatorAbstractFactory;
import com.interview.sde.java.oop.servlet.translator.TranslatorFromT;
import com.interview.sde.java.oop.servlet.translator.TranslatorToResponse;

public class RestTranslatorFactory implements TranslatorAbstractFactory<RestRequest> {
    @Override
    public TranslatorFromT<RestRequest> createTranslatorFromT() {
        return new GenericRequestToRestRequestTranslator();
    }

    @Override
    public TranslatorToResponse<RestRequest> createTranslatorToResponse() {
        return new RestToResponseTranslator();
    }
}
