package com.interview.sde.java.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent {

    List<FileSystemComponent> fileList;

    Folder(String path) {
        super(path);
        fileList = new ArrayList<>();
    }

    @Override
    boolean remove(FileSystemComponent file) {
        return fileList.remove(file);
    }

    @Override
    boolean add(FileSystemComponent file) {
        return add(List.of(file));
    }

    @Override
    boolean add(List<FileSystemComponent> files) {
        return fileList.addAll(List.copyOf(files));
    }

}
