package com.interview.sde.java.oop.servlet.translator;

import com.interview.sde.java.oop.servlet.servlet.Request;

public interface TranslatorFromT<T> {
    T translateToRequestSubclass(Request request);
}
