package com.interview.sde.java.datastructure;

//https://leetcode.com/problems/design-a-text-editor
public class TextEditor {

    int cursor = 0;
    StringBuilder text = new StringBuilder();

    public TextEditor() {

    }

    public void addText(String text) {
        this.text.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        if (cursor - k < 0) {
            k = cursor;
        }
        text.delete(cursor - k, cursor);
        cursor -= k;
        return k;
    }

    public String cursorLeft(int k) {

        cursor -= k;
        if (cursor < 0) {
            cursor = 0;
        }

        return text.substring(Math.max(0, cursor - Math.min(10, text.length())), cursor);
    }

    public String cursorRight(int k) {

        cursor += k;
        if (cursor > text.length()) {
            cursor = text.length();
        }

        return text.substring(Math.max(0, cursor - Math.min(10, text.length())), cursor);
    }
}
