package com.interview.sde.algorithm.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem
public class MinimumSwaps2 {
    static int findMinIdx(int[] arr, int index){
        int min = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        for (;index < arr.length; index++){
            if (min > arr[index]){
                min = arr[index];
                minIdx = index;
            }
        }
        return minIdx;
    }

    static void swap(int[] arr, int a, int b){
        int aux = arr[a];
        arr[a]=arr[b];
        arr[b]=aux;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int count = 0;
        for(int i = 0, end = arr.length-1 ; i < end; i++){
            int idx = findMinIdx(arr, i);
            if(end+1 == arr[end]){
                end --;
            }
            if(idx != i){
                swap(arr, i, idx);
                count++;
            }
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

