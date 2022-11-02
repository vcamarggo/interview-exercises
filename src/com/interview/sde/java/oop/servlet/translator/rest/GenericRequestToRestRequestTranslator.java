package com.interview.sde.oop.servlet.translator.rest;

import com.interview.sde.oop.servlet.servlet.Request;
import com.interview.sde.oop.servlet.servlet.RestRequest;
import com.interview.sde.oop.servlet.translator.TranslatorFromT;

public class GenericRequestToRestRequestTranslator implements TranslatorFromT<RestRequest> {
    @Override
    public RestRequest translateToRequestSubclass(final Request request) {
        //Intentionally left null
        return null;
    }
}
