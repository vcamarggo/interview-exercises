package com.interview.sde.mock.servlet.translator.rest;

import com.interview.sde.mock.servlet.servlet.Request;
import com.interview.sde.mock.servlet.servlet.RestRequest;
import com.interview.sde.mock.servlet.translator.TranslatorFromT;

public class GenericRequestToRestRequestTranslator implements TranslatorFromT<RestRequest> {
    @Override
    public RestRequest translateToRequestSubclass(final Request request) {
        //Intentionally left null
        return null;
    }
}
