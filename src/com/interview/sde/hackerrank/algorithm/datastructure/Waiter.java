package com.interview.sde.hackerrank.algorithm.datastructure;

import java.util.*;

//https://www.hackerrank.com/challenges/waiter/problem
public class Waiter {
    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        Queue<Stack<Integer>> queueOfB = new LinkedList<>();
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackATemp = new Stack<>();

        List<Integer> primes = primeGenerator(q);

        for (Integer element : number) {
            stackA.push(element);
        }

        for (int i = 0; i < q; i++) {
            stackATemp.clear();
            Stack<Integer> stackB = new Stack<>();
            while (!stackA.isEmpty()) {
                int ithPrime = primes.get(i);
                int elementOnTop = stackA.pop();
                if (elementOnTop % ithPrime == 0) {
                    stackB.push(elementOnTop);
                } else {
                    stackATemp.push(elementOnTop);
                }
            }
            queueOfB.add(stackB);
            stackA = (Stack<Integer>) stackATemp.clone();
        }

        int index = 0;
        int[] result = new int[number.length];
        while (!queueOfB.isEmpty()) {
            Stack<Integer> stackB = queueOfB.remove();
            while (!stackB.isEmpty()) {
                result[index++] = stackB.pop();
            }
        }

        while (!stackA.isEmpty()) {
            result[index++] = stackA.pop();
        }

        return result;
    }

    public static List<Integer> primeGenerator(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        int i = 3;
        if (n > 2) {
            while (primeNumbers.size() <= n) {
                i++;
                boolean status = true;
                for (int j = 2; j < i / 2 + 1; j++) {
                    if (i % j == 0) {
                        status = false;
                        break;
                    }
                }
                if (status) {
                    primeNumbers.add(i);
                }
            }
        }
        return primeNumbers;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(result[resultItr]);

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }
    }
}

