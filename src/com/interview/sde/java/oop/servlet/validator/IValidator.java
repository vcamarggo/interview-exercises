package com.interview.sde.java.oop.servlet.validator;

public interface IValidator<T> {

    void validate(final T data) throws ValidationException;

}

