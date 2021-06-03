package com.interview.sde.oop.servlet;

import com.interview.sde.oop.servlet.servlet.Request;
import com.interview.sde.oop.servlet.servlet.Response;
import com.interview.sde.oop.servlet.servlet.RestRequest;
import com.interview.sde.oop.servlet.servlet.Servlet;
import com.interview.sde.oop.servlet.translator.TranslatorAbstractFactory;
import com.interview.sde.oop.servlet.translator.rest.RestTranslatorFactory;
import com.interview.sde.oop.servlet.validator.ValidationException;
import com.interview.sde.oop.servlet.validator.ValidatorDecorator;
import com.interview.sde.oop.servlet.validator.ValidatorEmailSize;
import com.interview.sde.oop.servlet.validator.ValidatorNameSize;
import com.interview.sde.oop.servlet.validator.thirdparty.ValidatorThirdParty;

//If I use Generics on Servlet implementation, I can simplify translator usage here
class SignupActivity implements Servlet {

    //I did not want ot use wildcard ?, so I preferred to initialize the translator here
    final TranslatorAbstractFactory<RestRequest> translator = new RestTranslatorFactory();

    ValidatorDecorator<RestRequest> validator;

    public SignupActivity() {
        //Expose this with FluentBuilder would be a better idea
        //This sequence of validation could have come by parameter too
        validator = new ValidatorEmailSize<>(new ValidatorNameSize<>(new ValidatorThirdParty<>()));
    }

    @Override
    public void doPost(Request request, Response response) {
        RestRequest signUpRequest = translator.createTranslatorFromT().translateToRequestSubclass(request);
        try {
            validator.validate(signUpRequest);
        } catch (ValidationException ve) {
            response.setFailMessage(ve.getMessage());
            return;
        }
        response.setBody(translator.createTranslatorToResponse().translateToResponse(signUpRequest));
    }
}
