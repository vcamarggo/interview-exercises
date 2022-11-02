package com.interview.sde.oop.servlet.validator;

import com.interview.sde.oop.servlet.servlet.Request;

public class NoOpValidator<T extends Request> implements IValidator<T> {
    @Override
    public void validate(T data) throws ValidationException {
    }
}
