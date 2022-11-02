package com.interview.sde.java.oop.coffeemachine;

import com.interview.sde.java.oop.coffeemachine.state.IBeverageState;
import com.interview.sde.java.oop.coffeemachine.beverage.Beverage;
import com.interview.sde.java.oop.coffeemachine.beverage.maker.IBeverageMaker;
import com.interview.sde.java.oop.coffeemachine.payment.IPaymentMethod;
import com.interview.sde.java.oop.coffeemachine.payment.IPaymentProcessor;
import com.interview.sde.java.oop.coffeemachine.state.BeverageState;

import java.util.ArrayList;
import java.util.List;


//This was an idea from the great tskira
// https://github.com/tskira

//## Requirements:
//
//1 - Accept coins 5, 10, 25, 50 Cents
//
//2 - Accept 1 and 2 dollar note
//
//3 - Allow users to select products:
//    - Americano
//    - Expresso
//    - Cappuccino
//
//4 - Return selected product and remaining change if any
//
//5 - Allow user to take refund by canceling the Requirements
//
class BeverageMachine {

    IBeverageState beveragePreparingProcess;
    IPaymentProcessor paymentProcessor;
    IBeverageMaker beverageMaker;

    private List<Beverage> listBeverages() {
        beveragePreparingProcess.transitionState(BeverageState.INITIAL);
        //Move this logic to a beverage manager class
        return new ArrayList<>();
    }

    double payBeverage(final Integer beverageId, final List<IPaymentMethod> paymentsUsed) {
        double remainingToPay = paymentProcessor.processPayment(beverageId, paymentsUsed);

        //If fully paid or paid and receiving changes
        if (remainingToPay <= 0) {
            beveragePreparingProcess.transitionState(BeverageState.PREPARING);
            beverageMaker.makeBeverage(beverageId);
        }

        return remainingToPay;
    }

    //An observer can be inserted here to observe and notify when the beverageMaker finishes
    Beverage collectBeverage() {
        beveragePreparingProcess.transitionState(BeverageState.FINISHED);
        return beverageMaker.getBeverage();
    }

    double askRefund() {
        beveragePreparingProcess.transitionState(BeverageState.CANCELED);
        return paymentProcessor.refundPayment();
    }

}




