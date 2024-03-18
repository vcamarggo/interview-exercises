package com.interview.sde.java.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//https://leetcode.com/problems/print-foobar-alternately/
public class AlternateFooBarReentrantLock {
    private int n;

    Lock l = new ReentrantLock();
    Condition canFoo = l.newCondition();
    Condition canBar = l.newCondition();

    private boolean isFoo = true;

    public AlternateFooBarReentrantLock(int n) {
        this.n = n;
        try{
            l.lock();
            canFoo.signal();
        }finally{
            l.unlock();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            try{
                l.lock();
                while(!isFoo){
                    canFoo.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo=false;
                canBar.signal();
            }finally{
                l.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            try{
                l.lock();
                while(isFoo){
                    canBar.await();
                }
                printBar.run();
                isFoo=true;
                canFoo.signal();
            }finally{
                l.unlock();
            }
        }
    }
}
