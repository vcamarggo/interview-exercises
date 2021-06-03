package com.interview.sde.algorithm.datastructure;

import java.io.IOException;
import java.util.*;

public class QueriesWithFixedLength {

    // Complete the solve function below.
    static int[] solve(int[] arr, int[] queries) {
        int[] result = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int conseqSubseqSize = queries[k];

            Queue<Integer> subsequence = new LinkedList<>();
            int i = 0;

            for (; i < conseqSubseqSize; i++) {
                subsequence.add(arr[i]);
            }

            int max = Collections.max(subsequence);
            int min = max;

            for (; i < arr.length; i++) {
                int removed = subsequence.remove();
                subsequence.add(arr[i]);
                if (removed == max) {
                    max = Collections.max(subsequence);
                }
                if (max < min) {
                    min = max;
                }

            }
            result[k] = min;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        int[] queries = new int[q];

        for (int queriesItr = 0; queriesItr < q; queriesItr++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[queriesItr] = queriesItem;
        }

        int[] result = solve(arr, queries);
        System.out.println(Arrays.toString(result));

        scanner.close();
    }
}
