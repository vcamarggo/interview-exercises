package com.interview.sde.mock.servlet.translator;

import com.interview.sde.mock.servlet.servlet.Request;

public interface TranslatorFromT<T> {
     T translateToRequestSubclass(Request request);
}
