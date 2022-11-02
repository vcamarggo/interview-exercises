package com.interview.sde.java.designpatterns.composite;

public class Runner {
    public static void main(String[] args) {
        FileSystemComponent base = new Folder("/");

        FileSystemComponent folder = new Folder("blah");
        folder.add(new File("dogs.txt"));

        base.add(folder);

    }
}
