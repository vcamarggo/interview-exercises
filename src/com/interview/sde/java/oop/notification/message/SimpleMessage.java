package com.interview.sde.java.oop.notification.message;

public class SimpleMessage implements Message{

    private final Topic topic;
    private final String data;

    public SimpleMessage(Topic topic, String data) {
        this.topic = topic;
        this.data = data;
    }

    @Override
    public Topic getTopic() {
        return topic;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "topic=" + topic +
                ", data='" + data + '\'' +
                '}';
    }
}
