package com.interview.sde.java.concurrency;

//https://leetcode.com/problems/print-foobar-alternately/
public class AlternateFooBar {
    private final int n;
    private boolean isBar = false;

    public AlternateFooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                //while to protect against spurious wakeups
                while (isBar) {
                    this.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isBar = true;
                this.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                //while to protect against spurious wakeups
                while (!isBar) {
                    this.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isBar = false;
                this.notifyAll();
            }
        }
    }
}
