package com.interview.sde.java.oop.notification.dao;

import com.interview.sde.java.oop.notification.subscriber.Subscriber;
import com.interview.sde.java.oop.notification.message.Topic;

import java.util.List;

public interface DAO {

    List<Subscriber> getAllSubscribers(Topic topic);

    boolean addSubscriberToTopic(Subscriber subscriber, Topic topic);

    boolean removeSubscriberToTopic(Subscriber subscriber, Topic topic);
}
