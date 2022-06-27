package com.interview.sde.oop.notification.subscriber;

import com.interview.sde.oop.notification.message.Message;

public interface Subscriber {
    
    void notify(Message message);
    
}
