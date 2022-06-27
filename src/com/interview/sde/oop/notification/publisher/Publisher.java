package com.interview.sde.oop.notification.publisher;

import com.interview.sde.oop.notification.message.Message;
import com.interview.sde.oop.notification.message.Topic;
import com.interview.sde.oop.notification.subscriber.Subscriber;

public interface Publisher {

    boolean subscribe(Subscriber subscriber, Topic topic);

    boolean unsubscribe(Subscriber subscriber, Topic topic);

    void receiveMessage(Message message);
}
