package com.interview.sde.java.oop.servlet.validator;

import com.interview.sde.java.oop.servlet.servlet.Request;

public abstract class ValidatorDecorator<T extends Request> implements IValidator<T> {

    IValidator<T> validator;

    public ValidatorDecorator(IValidator<T> validator) {
        this.validator = validator;
    }

    public ValidatorDecorator() {
        validator = new NoOpValidator<>();
    }

    @Override
    public void validate(T data) throws ValidationException {
        validator.validate(data);
    }
}
