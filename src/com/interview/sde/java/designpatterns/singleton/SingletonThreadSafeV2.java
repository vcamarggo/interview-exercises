package com.interview.sde.designpatterns.singleton;

public class SingletonThreadSafeV2 {

    private SingletonThreadSafeV2() {
    }

    private static class SingletonThreadSafeness {
        private static final SingletonThreadSafeV2 INSTANCE = new SingletonThreadSafeV2();
    }

    public static SingletonThreadSafeV2 getInstance() {
        return SingletonThreadSafeness.INSTANCE;
    }

    public void doSingletonStuff() {
        System.out.println("working");
    }
}
