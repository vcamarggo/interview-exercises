package com.interview.sde.mock.servlet.translator.rest;

import com.interview.sde.mock.servlet.servlet.RestRequest;
import com.interview.sde.mock.servlet.translator.TranslatorAbstractFactory;
import com.interview.sde.mock.servlet.translator.TranslatorFromT;
import com.interview.sde.mock.servlet.translator.TranslatorToResponse;

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
