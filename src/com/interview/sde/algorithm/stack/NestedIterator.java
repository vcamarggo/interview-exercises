package com.interview.sde.algorithm.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/flatten-nested-list-iterator/
public class NestedIterator implements Iterator<Integer> {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    private Context current;
    private final Stack<Context> iterationStack;

    public static class Context {
        private int currentIndex;
        private final List<NestedInteger> elements;

        public Context(List<NestedInteger> elements) {
            this.currentIndex = 0;
            this.elements = elements;
        }

        boolean isInteger() {
            return elements.get(currentIndex).isInteger();
        }

        Integer getInteger() {
            return elements.get(currentIndex++).getInteger();
        }

        List<NestedInteger> getList() {
            return elements.get(currentIndex++).getList();
        }

        boolean hasNext() {
            return currentIndex < elements.size();
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        this.current = new Context(nestedList);
        this.iterationStack = new Stack<>();

    }

    @Override
    public Integer next() {
        return current.getInteger();
    }

    @Override
    public boolean hasNext() {
        if (hasNextInteger()) return true;
        while (!iterationStack.isEmpty()) {
            current = iterationStack.pop();
            if (hasNextInteger()) return true;
        }
        return false;
    }

    private boolean hasNextInteger() {
        while (current.hasNext() && !current.isInteger()) {
            Context previous = current;
            current = new Context(previous.getList());
            iterationStack.push(previous);
        }
        return current.hasNext() && current.isInteger();
    }


}
