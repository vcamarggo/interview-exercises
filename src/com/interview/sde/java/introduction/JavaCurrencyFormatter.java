package com.interview.sde.java.introduction;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-currency-formatter/problem
public class JavaCurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        scanner.close();

        String us = NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(amount);
        NumberFormat df = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("Rs.");
        dfs.setGroupingSeparator(',');
        dfs.setMonetaryDecimalSeparator('.');
        ((DecimalFormat) df).setDecimalFormatSymbols(dfs);

        String india = df.format(amount);

        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount);
        String france = NumberFormat.getCurrencyInstance(new Locale("fr", "FR")).format(amount);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}


