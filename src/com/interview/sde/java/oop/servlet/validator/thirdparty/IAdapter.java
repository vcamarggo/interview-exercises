package com.interview.sde.oop.servlet.validator.thirdparty;

import com.interview.sde.oop.servlet.validator.IValidator;
import com.interview.sde.oop.servlet.validator.ValidationException;

public interface IAdapter<T> extends IValidator<T> {
    void validate(final T data) throws ValidationException;
}
