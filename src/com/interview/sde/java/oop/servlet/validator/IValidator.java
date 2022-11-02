package com.interview.sde.oop.servlet.validator;

public interface IValidator<T> {

    void validate(final T data) throws ValidationException;

}

