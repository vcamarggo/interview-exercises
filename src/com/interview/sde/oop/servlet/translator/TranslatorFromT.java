package com.interview.sde.oop.servlet.translator;

import com.interview.sde.oop.servlet.servlet.Request;

public interface TranslatorFromT<T> {
     T translateToRequestSubclass(Request request);
}
