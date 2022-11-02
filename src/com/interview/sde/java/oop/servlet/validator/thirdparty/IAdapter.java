package com.interview.sde.java.oop.servlet.validator.thirdparty;

import com.interview.sde.java.oop.servlet.validator.IValidator;
import com.interview.sde.java.oop.servlet.validator.ValidationException;

public interface IAdapter<T> extends IValidator<T> {
    void validate(final T data) throws ValidationException;
}
