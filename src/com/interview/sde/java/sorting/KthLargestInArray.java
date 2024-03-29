package com.interview.sde.java.sorting;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestInArray {
    public static void main(String[] args) {
        System.out.println(new KthLargestInArray().kthSmallestNumberQuickSelect(new String[]{"1", "2", "3", "4", "14"}, 2));
        System.out.println(new KthLargestInArray().kthLargestNumberQuickSelect(new String[]{"1", "2", "3", "4", "14"}, 2));
        System.out.println(new KthLargestInArray().kthLargestNumber(new String[]{"1", "2", "3", "4", "14"}, 2));
        System.out.println(new KthLargestInArray().kthLargestNumber2(new String[]{"1", "2", "3", "4", "14"}, 2));
    }

    //Code to pass on leetcode
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, getComparator());
        return nums[nums.length - k];
    }

    public String kthLargestNumber2(String[] nums, int k) {
        Arrays.sort(nums, getComparator().reversed());
        return nums[k-1];
    }

    //Example of QuickSelect to solve the same problem
    public String kthSmallestNumberQuickSelect(String[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1, getComparator());
    }

    public String kthLargestNumberQuickSelect(String[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1, getComparator().reversed());
    }

    public String quickSelect(String[] nums, int k, int start, int end, Comparator<String> comparator) {
        int p = partition(nums, start, end, comparator);
        if (p == k) {
            return String.valueOf(nums[p]);
        }
        return (k > p) ? quickSelect(nums, k, p + 1, end, comparator) : quickSelect(nums, k, start, p - 1, comparator);
    }

    int partition(String[] nums, int start, int end, Comparator<String> comparator) {
        String partition = nums[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if (comparator.compare(nums[i], partition) <= 0) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, end);
        return j;
    }

    private Comparator<String> getComparator() {
        return Comparator.comparing(String::length).thenComparing(String::compareTo);
    }

    void swap(String[] nums, int a, int b) {
        String temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
