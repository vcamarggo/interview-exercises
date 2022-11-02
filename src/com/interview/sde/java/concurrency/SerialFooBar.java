package com.interview.sde.java.concurrency;

import java.util.concurrent.CountDownLatch;

//https://leetcode.com/problems/print-in-order/
public class SerialFooBar {

    final CountDownLatch latchOne = new CountDownLatch(1);
    final CountDownLatch latchTwo = new CountDownLatch(1);


    public SerialFooBar() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latchOne.countDown();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        latchOne.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latchTwo.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latchTwo.await();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
