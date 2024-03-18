package com.interview.sde.java.oop.notification.subscriber;

import com.interview.sde.java.oop.notification.message.Message;

public interface Subscriber {

    void notify(Message message);

}
