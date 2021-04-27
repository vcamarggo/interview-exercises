package com.interview.sde.mock.servlet.validator.thirdparty;

import com.interview.sde.mock.servlet.servlet.Request;
import com.interview.sde.mock.servlet.validator.IValidator;
import com.interview.sde.mock.servlet.validator.ValidationException;
import com.interview.sde.mock.servlet.validator.ValidatorDecorator;

public class ValidatorThirdParty<T extends Request> extends ValidatorDecorator<T> {

    //Consumer defines who is the adaptee
    private IAdapter<T> thirdPartyAdapter = new ThirdPartyAdapter<>();

    public ValidatorThirdParty(IValidator<T> validator) {
        super(validator);
    }

    public ValidatorThirdParty() {
    }

    @Override
    public void validate(final T data) throws ValidationException {
        super.validate(data);
        thirdPartyAdapter.validate(data);
    }
}