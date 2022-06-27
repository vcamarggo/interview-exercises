package com.interview.sde.oop.notification.dao;

import com.interview.sde.oop.notification.message.Topic;
import com.interview.sde.oop.notification.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticSubscribers implements DAO {

    private final Map<Topic, List<Subscriber>> subscribers;

    public StaticSubscribers() {
        this.subscribers = new HashMap<>();
    }

    @Override
    public List<Subscriber> getAllSubscribers(Topic topic) {
        return subscribers.getOrDefault(topic, new ArrayList<>());
    }

    @Override
    public boolean addSubscriberToTopic(Subscriber subscriber, Topic topic) {
        return subscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    @Override
    public boolean removeSubscriberToTopic(Subscriber subscriber, Topic topic) {
        return getAllSubscribers(topic).remove(subscriber);
    }

}
