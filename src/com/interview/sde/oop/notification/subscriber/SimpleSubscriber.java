package com.interview.sde.oop.notification.subscriber;

import com.interview.sde.oop.notification.message.Message;

public class SimpleSubscriber implements Subscriber {

    private static long ID = 1;
    private final long id;

    public SimpleSubscriber() {
        id = ID++;
    }

    @Override
    public void notify(Message message) {
        System.out.println(id + " " + message.toString());
    }

}
