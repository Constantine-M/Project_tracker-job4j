package ru.job4j.ex;

public class FindMaxLenght {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        String winner = null;
        for (int i = 0; i < shops.length; i++) {
            String el = shops[i];
            if (el != null && el.length() > max) {
                max = el.length();
                winner = el;
            }
        }
        System.out.println("And the winner is " + winner + " with max length: " + max);
    }
}
