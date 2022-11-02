package com.interview.sde.oop.servlet.validator;

import com.interview.sde.oop.servlet.servlet.Request;

public class ValidatorNameSize<T extends Request> extends ValidatorDecorator<T> {
    private static final int MIN_SIZE = 3;

    public ValidatorNameSize(IValidator<T> validator) {
        super(validator);
    }

    public ValidatorNameSize() {
        super();
    }

    @Override
    public void validate(final T data) throws ValidationException {
        super.validate(data);
        String name = data.getParam("name");
        if (name == null || name.length() < MIN_SIZE) {
            throw new ValidationException();
        }
    }
}
