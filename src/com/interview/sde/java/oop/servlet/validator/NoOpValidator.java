package com.interview.sde.java.oop.servlet.validator;

import com.interview.sde.java.oop.servlet.servlet.Request;

public class NoOpValidator<T extends Request> implements IValidator<T> {
    @Override
    public void validate(T data) throws ValidationException {
    }
}
