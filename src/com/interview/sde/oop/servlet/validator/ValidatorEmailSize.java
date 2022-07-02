package com.interview.sde.oop.servlet.validator;

import com.interview.sde.oop.servlet.servlet.Request;

public class ValidatorEmailSize<T extends Request> extends ValidatorDecorator<T> {

    private static final int MIN_SIZE = 10;

    public ValidatorEmailSize(IValidator<T> validator) {
        super(validator);
    }

    public ValidatorEmailSize() {
        super();
    }

    @Override
    public void validate(final T data) throws ValidationException {
        super.validate(data);
        String email = data.getParam("email");
        if (email == null || email.length() < MIN_SIZE) {
            throw new ValidationException();
        }
    }
}
