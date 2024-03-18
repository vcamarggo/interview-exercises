package com.interview.sde.java.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

//https://leetcode.com/problems/avoid-flood-in-the-city/
public class LakeFlood {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 0, 1, 2})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{69, 0, 0, 0, 69})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{10, 20, 20})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{0, 1, 1})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 0, 2, 0, 2, 1})));
    }

    public static int[] avoidFlood(int[] rains) {
        int[] solution = new int[rains.length];
        HashMap<Integer, Integer> fullWhen = new HashMap<>(rains.length);
        //Stores where and when a rain happened, to allow dry the lake ONLY AFTER it has been filled
        TreeSet<Integer> dryDays = new TreeSet<>();
        //Tried with Queue/List, but it is expensive and complex to search the threshold
        // Allow to overcome the case while you can only clean after a threshold, like on line drydays.higher()

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                solution[i] = 1;
            } else {
                int rain = rains[i];
                if (fullWhen.containsKey(rain)) {
                    Integer day = dryDays.higher(fullWhen.get(rain));
                    if (day == null) { //If there is no dry days left after the initial date where the lake is filled
                        return new int[0];
                    }
                    solution[day] = rain;
                    dryDays.remove(day);
                }
                solution[i] = -1;
                fullWhen.put(rain, i); // Create/Update threshold when the lake was filled
            }
        }
        return solution;
    }

//Slow version due to linear search for the next rain with already full lake
//    public int[] avoidFlood(int[] rains) {
//        int[] solution = new int[rains.length];
//        Set<Integer> full = new HashSet<>();
//
//        for(int i = 0 ; i < rains.length ; i++){
//            if(rains[i] == 0){
//
//                int j = i+1;
//                for( ; j < rains.length ; j++){
//                    //Linear search for the first occurrence of a given day into the next days
//                    if(full.contains(rains[j])){
//                        Integer key = rains[j];
//                        full.remove(key);
//                        solution[i] = key;
//                        break;
//                    }
//                }
//
//                if(j == rains.length ){
//                    solution[i] = 1;
//                }
//
//            } else if(!full.contains(rains[i])){
//                full.add(rains[i]);
//                solution[i] = -1;
//            } else {
//                return new int[0];
//            }
//        }
//        return solution;
//    }
}
