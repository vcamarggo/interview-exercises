package com.interview.sde.oop.notification;

import com.interview.sde.oop.notification.dao.DAO;
import com.interview.sde.oop.notification.dao.InMemorySubscribers;
import com.interview.sde.oop.notification.message.SimpleMessage;
import com.interview.sde.oop.notification.message.Topic;
import com.interview.sde.oop.notification.publisher.Publisher;
import com.interview.sde.oop.notification.publisher.SerialPublisher;
import com.interview.sde.oop.notification.subscriber.SimpleSubscriber;
import com.interview.sde.oop.notification.subscriber.Subscriber;

public class Context {
    public static void main(String[] args) {
        DAO subscriberDAO = new InMemorySubscribers();

        Publisher publisher = new SerialPublisher(subscriberDAO);

        Subscriber sub1 = new SimpleSubscriber();
        Subscriber sub2 = new SimpleSubscriber();

        Topic comedy = new Topic("comedy");
        Topic sports = new Topic("sports");
        Topic drama = new Topic("drama");
        Topic music = new Topic("music");

        publisher.subscribe(sub1, sports);
        publisher.subscribe(sub1, drama);
        publisher.subscribe(sub1, comedy);

        publisher.subscribe(sub2, music);
        publisher.subscribe(sub2, comedy);

        publisher.receiveMessage(new SimpleMessage(comedy, "Hahaha"));
        publisher.receiveMessage(new SimpleMessage(music, "pisadinha"));

        publisher.unsubscribe(sub2, comedy);

        publisher.receiveMessage(new SimpleMessage(comedy, "Hahaha"));

    }

}
