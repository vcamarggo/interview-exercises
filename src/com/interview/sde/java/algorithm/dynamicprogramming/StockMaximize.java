package com.interview.sde.algorithm.dynamicprogramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//This solution is overkill, a simple counter could be used to track the maximum so far
//https://www.hackerrank.com/challenges/stockmax/problem
public class StockMaximize {

    /*
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static long stockmax(int[] arr) {
        HashMap<Integer, Long> stocksAmount = new HashMap<>();
        stocksAmount.put(0, 0L);
        stocksAmount.put(1, (long) -arr[0]);

        for (int i = 1; i < arr.length; i++) {
            HashMap<Integer, Long> stocksAmountTemp = new HashMap<>();
            for (Map.Entry<Integer, Long> stockAmount : stocksAmount.entrySet()) {
                int buyKey = stockAmount.getKey() + 1;
                long buyValue = stockAmount.getValue() - arr[i];
                if (stocksAmount.containsKey(buyKey)) {
                    stocksAmountTemp.put(buyKey, Math.max(stocksAmount.get(buyKey), buyValue));
                } else {
                    stocksAmountTemp.put(buyKey, buyValue);
                }


                long sellValue = stockAmount.getValue() + stockAmount.getKey() * arr[i];
                stocksAmountTemp.put(0, Math.max(stocksAmountTemp.getOrDefault(0, Long.MIN_VALUE), sellValue));
            }
            stocksAmount.putAll(stocksAmountTemp);
        }
        return stocksAmount.get(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int[] prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                long result = stockmax(prices);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

