package com.interview.sde.algorithm.array;
//https://www.hackerrank.com/challenges/circular-array-rotation/problem
//https://leetcode.com/problems/rotate-array/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CircularArrayRotation {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the rotLeft function below.
    static int[] circularArrayRotation(List<Integer> a, int k, int[] queries) {
        Collections.rotate(a, k);

        return executeQueries(a.stream().mapToInt(Integer::intValue).toArray(), queries);
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] rotated = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (0 <= i - k) {
                rotated[i] = a[i - k];
            } else {
                rotated[i] = a[i - k + a.length];
            }

        }
        return executeQueries(rotated, queries);
    }

    private static int[] executeQueries(int[] array, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = array[queries[i]];
        }
        return result;
    }

    public void rotateInline(int[] nums, int k) {
        //Number of real rotations because for each K rotations where K equals array size
        //it would be the same as keeping array as it started
        final int realRotation = k % nums.length;
        final int lastIndex = nums.length - 1;

        //reverse end k (realRotation) elements
        reverseInline(nums, nums.length - realRotation, lastIndex);

        //reverse from first element until lastIndex - k (realRotation)
        reverseInline(nums, 0, lastIndex - realRotation);

        // reverse the whole array
        reverseInline(nums, 0, lastIndex);
    }

    void reverseInline(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        List<Integer> a = new ArrayList<>();

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int value : result) {
            System.out.println(value);
        }
        scanner.close();
    }
}

