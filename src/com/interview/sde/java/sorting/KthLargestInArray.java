package com.interview.sde.java.sorting;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
public class KthLargestInArray {
    public static void main(String[] args) {
        System.out.println(new KthLargestInArray().kthSmallestNumberQuickSelect(new String[]{"1", "2", "3", "4", "14"}, 2));
        System.out.println(new KthLargestInArray().kthLargestNumberQuickSelect(new String[]{"1", "2", "3", "4", "14"}, 2));
        System.out.println(new KthLargestInArray().kthLargestNumber(new String[]{"1", "2", "3", "4", "14"}, 2));
    }

    //Code to pass on leetcode
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, this::compareStr);
        return nums[nums.length - k];
    }

    //Example of QuickSelect to solve the same problem
    public String kthSmallestNumberQuickSelect(String[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1, this::compareStr);
    }

    public String kthLargestNumberQuickSelect(String[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1, (a, b) -> compareStr(b, a));
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

    private int compareStr(String s1, String s2) {
        return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
    }

    void swap(String[] nums, int a, int b) {
        String temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
