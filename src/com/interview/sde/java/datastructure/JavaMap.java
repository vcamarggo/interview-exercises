package com.interview.sde.java.datastructure;

import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/phone-book/problem
public class JavaMap {
    public static void main(String[] argh) {
        HashMap<String, Integer> phoneList = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            phoneList.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            if (phoneList.containsKey(s)) {
                System.out.println(s + "=" + phoneList.get(s));
            } else {
                System.out.println("Not found");
            }
        }
    }
}




