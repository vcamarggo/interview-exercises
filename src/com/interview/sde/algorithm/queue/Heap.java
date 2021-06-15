package com.interview.sde.algorithm.queue;

import java.util.Arrays;

public class Heap {

    static class HeapDS {

        private int[] data;
        private int elementsInserted;


        HeapDS(int capacity) {
            this.data = new int[capacity + 1];
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
            int temp = data[idxA];
            data[idxA] = data[idxB];
            data[idxB] = temp;
        }

        void add(int element) {
            if (elementsInserted == data.length - 1) {
                throw new ArrayIndexOutOfBoundsException();
            }
            data[++elementsInserted] = element;
            int index = elementsInserted;

            while (data[index] < data[getParent(index)]) {
                swap(index, getParent(index));
                index = getParent(index);
            }

        }

        int poll() {
            if (elementsInserted == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }

            int index = 1;
            int top = data[index];

            data[index] = data[elementsInserted];

            while (!isLeaf(index)) {
                int leftIndex = getLeft(index);
                int rightIndex = getRight(index);
                if (data[index] > data[leftIndex] || data[index] > data[rightIndex]) {
                    int minIndex = data[leftIndex] < data[rightIndex] ? leftIndex : rightIndex;
                    swap(minIndex, index);
                    index = minIndex;
                } else {
                    break;
                }
            }

            data[elementsInserted--] = 0;
            return top;
        }


        int peek() {
            return data[1];
        }

        public String getFullContentAsString() {
            return Arrays.toString(data);
        }
    }

    public static void main(String[] args) {
        HeapDS heap = new HeapDS(3);
        heap.add(10);
        heap.add(30);
        heap.add(20);
        heap.add(400);
        System.out.println(heap.peek());
        System.out.println(heap.getFullContentAsString());
        heap.poll();
        heap.add(35);
        System.out.println(heap.peek());
        System.out.println(heap.getFullContentAsString());
        heap.add(5);
        System.out.println(heap.peek());
        System.out.println(heap.getFullContentAsString());
        heap.add(10);
        heap.add(120);
        System.out.println(heap.peek());
        System.out.println(heap.getFullContentAsString());
        heap.add(104);
        System.out.println(heap.peek());
        System.out.println(heap.getFullContentAsString());
        heap.poll();
        heap.poll();
        heap.add(106);
        heap.add(8);
        heap.poll();
        heap.add(0);
        System.out.println(heap.peek());
        System.out.println(heap.getFullContentAsString());
    }
}
