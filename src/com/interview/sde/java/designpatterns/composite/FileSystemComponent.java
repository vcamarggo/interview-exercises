package com.interview.sde.java.designpatterns.composite;

import java.util.List;

public abstract class FileSystemComponent {

    final String path;

    FileSystemComponent(String path) {
        this.path = path;
    }

    boolean remove(FileSystemComponent file) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not implemented");
    }

    boolean add(FileSystemComponent file) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not implemented");
    }

    boolean add(List<FileSystemComponent> files) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
