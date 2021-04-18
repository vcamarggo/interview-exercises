package com.interview.sde.mock.servlet.translator.rest;

import com.interview.sde.mock.servlet.servlet.RestRequest;
import com.interview.sde.mock.servlet.translator.TranslatorToResponse;

public class RestToResponseTranslator implements TranslatorToResponse<RestRequest> {
    @Override
    public String translateToResponse(final RestRequest restRequest) {
        //Intentionally left null
        return null;
    }
}
