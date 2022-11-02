package com.interview.sde.java.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

class Heap<E extends Comparable<E>> {

    public static void main(String[] args) {
        Heap<Integer> minHeap = new Heap<>(10);
        Heap<Integer> maxHeap = new Heap<Integer>(10, Comparator.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(400);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.getFullContentAsString());
        maxHeap.remove();
        maxHeap.add(35);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.getFullContentAsString());
        maxHeap.add(5);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.getFullContentAsString());
        maxHeap.add(10);
        maxHeap.add(120);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.getFullContentAsString());
        maxHeap.add(104);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.getFullContentAsString());
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.add(106);
        maxHeap.add(8);
        maxHeap.remove();
        maxHeap.add(0);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.getFullContentAsString());
    }

    private final E[] data;
    private int elementsInserted;
    private Comparator<E> comparator;


    Heap(int capacity) {
        this.data = (E[]) java.lang.reflect.Array.newInstance(Comparable.class, capacity + 1);
        comparator = Comparator.naturalOrder();
    }

    Heap(int capacity, Comparator<E> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    private boolean isLeaf(int pos) {
        return pos >= (elementsInserted / 2) && pos <= elementsInserted;
    }

    private int getParent(int pos) {
        return pos / 2;
    }


    private int getLeft(int pos) {
        return (2 * pos);
    }

    private int getRight(int pos) {
        return (2 * pos) + 1;
    }

    private void swap(int idxA, int idxB) {
        E temp = data[idxA];
        data[idxA] = data[idxB];
        data[idxB] = temp;
    }

    boolean add(E element) {
        if (elementsInserted == data.length - 1) {
            return false;
        }
        data[++elementsInserted] = element;
        int index = elementsInserted;

        while (data[getParent(index)] != null && comparator.compare(data[index], data[getParent(index)]) < 0) {
            swap(index, getParent(index));
            index = getParent(index);
        }
        return true;
    }

    E remove() {
        if (elementsInserted == 0) {
            throw new NoSuchElementException();
        }

        int index = 1;
        E top = data[index];

        data[index] = data[elementsInserted];

        while (!isLeaf(index)) {
            int leftIndex = getLeft(index);
            int rightIndex = getRight(index);
            if (data[index] != null && data[leftIndex] != null && data[rightIndex] != null && (comparator.compare(data[index], data[leftIndex]) > 0 || comparator.compare(data[index], data[rightIndex]) > 0)) {
                int minIndex = data[leftIndex] != null && data[rightIndex] == null || comparator.compare(data[leftIndex], data[rightIndex]) < 0 ? leftIndex : rightIndex;
                swap(minIndex, index);
                index = minIndex;
            } else {
                break;
            }
        }

        data[elementsInserted--] = null;
        return top;
    }


    E peek() {
        return data[1];
    }

    int size() {
        return elementsInserted;
    }

    public String getFullContentAsString() {
        return Arrays.toString(data);
    }
}
