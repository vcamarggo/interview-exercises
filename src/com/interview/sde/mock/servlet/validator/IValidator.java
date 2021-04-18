package com.interview.sde.mock.servlet.validator;

public interface IValidator<T>{

    void validate(final T data) throws ValidationException;

}

