package com.interview.sde.oop.servlet.validator;

import com.interview.sde.oop.servlet.servlet.Request;

public abstract class ValidatorDecorator<T extends Request> implements IValidator<T>{

    IValidator<T> validator;

    public ValidatorDecorator(IValidator<T> validator) {
        this.validator = validator;
    }

    public ValidatorDecorator() {
    }

    @Override
    public void validate(T data) throws ValidationException {
        validator.validate(data);
    }
}
