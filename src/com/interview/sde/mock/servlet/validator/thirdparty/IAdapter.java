package com.interview.sde.mock.servlet.validator.thirdparty;

import com.interview.sde.mock.servlet.validator.IValidator;
import com.interview.sde.mock.servlet.validator.ValidationException;

public interface IAdapter<T> extends IValidator<T> {
    void validate(final T data) throws ValidationException;
}
