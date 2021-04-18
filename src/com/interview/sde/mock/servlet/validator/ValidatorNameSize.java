package com.interview.sde.mock.servlet.validator;

import com.interview.sde.mock.servlet.servlet.Request;

public class ValidatorNameSize<T extends Request> extends ValidatorDecorator<T> {
    private static final int MIN_SIZE = 3;

    public ValidatorNameSize(IValidator<T> validator) {
        super(validator);
    }

    public ValidatorNameSize() {
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
