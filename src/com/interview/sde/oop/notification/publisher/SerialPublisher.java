package com.interview.sde.oop.notification.publisher;

import com.interview.sde.oop.notification.message.Message;
import com.interview.sde.oop.notification.message.Topic;
import com.interview.sde.oop.notification.dao.DAO;
import com.interview.sde.oop.notification.subscriber.Subscriber;

public class SerialPublisher implements Publisher {

    private final DAO subscriberDAO;
    public SerialPublisher(DAO subscriberDAO) {
        this.subscriberDAO = subscriberDAO;
    }

    @Override
    public boolean subscribe(Subscriber subscriber, Topic topic) {
        return subscriberDAO.addSubscriberToTopic(subscriber, topic);
    }

    @Override
    public boolean unsubscribe(Subscriber subscriber, Topic topic) {
        return subscriberDAO.removeSubscriberToTopic(subscriber, topic);
    }

    @Override
    public void receiveMessage(Message message) {
        for (Subscriber subscriber : subscriberDAO.getAllSubscribers(message.getTopic())){
            subscriber.notify(message);
        }
    }


}
