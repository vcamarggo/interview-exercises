package com.interview.sde.oop.servlet.validator.thirdparty;

import com.interview.sde.oop.servlet.validator.ValidationException;

public class ThirdPartyAdapter<T> implements IAdapter<T> {

    private final ThirdPartyLibrary adaptee;

    public ThirdPartyAdapter() {
        this.adaptee = new ThirdPartyLibrary();
    }

    @Override
    public void validate(final T data) throws ValidationException {
        //Adapt adaptee logic
        //...
        adaptee.doSomething();
        //...
    }
}
