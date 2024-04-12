package com.interview.sde.java.array;

//https://leetcode.com/problems/fruit-into-baskets
public class TwoFruitsBasket {
    public int totalFruit(int[] fruits) {
        int max = 0;

        for (int i = 0; i < fruits.length; i++) {
            int fruit1 = fruits[i];
            int fruit2 = -1;
            int fruit2Index = -1;

            int j = i + 1;
            while (j < fruits.length && (fruit2 == -1 || fruit1 == fruits[j] || fruit2 == fruits[j])) {
                if (fruit2Index == -1 && fruit1 != fruits[j]) {
                    fruit2 = fruits[j];
                    fruit2Index = j;
                }
                j++;
            }
            max = Math.max(max, j - i);
            if (fruit2Index != -1) {
                i = fruit2Index - 1;
            }
        }

        return max;
    }

}
