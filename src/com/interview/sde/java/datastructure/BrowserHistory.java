package com.interview.sde.java.datastructure;

//https://leetcode.com/problems/design-browser-history
public class BrowserHistory {
    static class DoublyLinkedList{
        String url;
        DoublyLinkedList next;
        DoublyLinkedList prev;
        DoublyLinkedList(String url, DoublyLinkedList prev){
            this.url = url;
            this.prev = prev;
        }
        DoublyLinkedList(String url){
            this.url = url;
        }
    }

    private DoublyLinkedList current;

    public BrowserHistory(String homepage) {
        this.current = new DoublyLinkedList(homepage);
    }

    public void visit(String url) {
        this.current.next = new DoublyLinkedList(url, this.current);
        this.current = this.current.next;
    }

    public String back(int steps) {
        while(steps-- > 0 && this.current.prev != null){
            this.current = this.current.prev;
        }
        return this.current.url;
    }

    public String forward(int steps) {
        while(steps-- > 0 && this.current.next != null){
            this.current = this.current.next;
        }
        return this.current.url;
    }
}
