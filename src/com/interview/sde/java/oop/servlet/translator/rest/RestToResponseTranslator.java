package com.interview.sde.java.oop.servlet.translator.rest;

import com.interview.sde.java.oop.servlet.servlet.RestRequest;
import com.interview.sde.java.oop.servlet.translator.TranslatorToResponse;

public class RestToResponseTranslator implements TranslatorToResponse<RestRequest> {
    @Override
    public String translateToResponse(final RestRequest restRequest) {
        //Intentionally left null
        return null;
    }
}
