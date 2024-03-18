package com.interview.sde.java.oop.notification.message;

public record SimpleMessage(Topic topic, String data) implements Message {

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "topic=" + topic +
                ", data='" + data + '\'' +
                '}';
    }
}
