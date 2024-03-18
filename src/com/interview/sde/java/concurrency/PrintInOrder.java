package com.interview.sde.java.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//https://leetcode.com/problems/print-in-order/
public class PrintInOrder {

    Lock l = new ReentrantLock();
    Condition firstStarted = l.newCondition();
    Condition secondStarted = l.newCondition();

    private boolean printed1 = false;
    private boolean printed2 = false;

    public PrintInOrder() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            l.lock();

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            printed1 = true;

            firstStarted.signal();
        } finally {
            l.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            l.lock();

            while (!printed1) {
                firstStarted.awaitUninterruptibly();
            }

            // printFirst.run() outputs "first". Do not change or remove this line.
            printSecond.run();
            printed2 = true;

            secondStarted.signal();
        } finally {
            l.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            l.lock();

            while (!printed2) {
                secondStarted.awaitUninterruptibly();
            }

            // printFirst.run() outputs "first". Do not change or remove this line.
            printThird.run();

        } finally {
            l.unlock();
        }
    }
}
