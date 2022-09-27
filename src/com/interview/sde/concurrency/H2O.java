package com.interview.sde.concurrency;

import java.util.concurrent.Semaphore;

public class H2O {
    public H2O() {

    }

    private final Semaphore h2 = new Semaphore(2);
    private final Semaphore o = new Semaphore(1);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h2.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        synchronized (this) {
            if (h2.availablePermits() == 0) {
                o.release();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h2.release(2);
    }
}
