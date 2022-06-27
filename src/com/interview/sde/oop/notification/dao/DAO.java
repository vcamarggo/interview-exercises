package com.interview.sde.oop.notification.dao;

import com.interview.sde.oop.notification.subscriber.Subscriber;
import com.interview.sde.oop.notification.message.Topic;

import java.util.List;

public interface DAO {

    List<Subscriber> getAllSubscribers(Topic topic);

    boolean addSubscriberToTopic(Subscriber subscriber, Topic topic);

    boolean removeSubscriberToTopic(Subscriber subscriber, Topic topic);
}
