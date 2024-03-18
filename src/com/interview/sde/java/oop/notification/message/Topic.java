package com.interview.sde.java.oop.notification.message;

public record Topic(String name) {

    @Override
    public String toString() {
        return name();
    }
}
