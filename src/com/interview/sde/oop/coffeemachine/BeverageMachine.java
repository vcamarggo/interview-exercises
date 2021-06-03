package com.interview.sde.oop.coffeemachine;

import com.interview.sde.oop.coffeemachine.beverage.Beverage;
import com.interview.sde.oop.coffeemachine.beverage.maker.IBeverageMaker;
import com.interview.sde.oop.coffeemachine.payment.IPayment;
import com.interview.sde.oop.coffeemachine.payment.IPaymentProcessor;
import com.interview.sde.oop.coffeemachine.state.BeverageState;
import com.interview.sde.oop.coffeemachine.state.IBeverageState;

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

    double payBeverage(final Integer beverageId, final List<IPayment> IPayment) {
        double remainingToPay = paymentProcessor.processPayment(beverageId, IPayment);

        //If fully paid or paid and receiving changes
        if (remainingToPay <= 0) {
            beveragePreparingProcess.transitionState(BeverageState.PREPARING);
            beverageMaker.makeBeverage();
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




