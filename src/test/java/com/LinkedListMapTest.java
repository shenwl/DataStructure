package com;

import java.util.ArrayList;

public class LinkedListMapTest {
    public static void main(String[] args) {
        LinkedListMap<String, Integer> map = new LinkedListMap<>();

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/Pride_and_Prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
        }

        System.out.println("Map size: " + map.getSize());;
        System.out.println("Frequency of pride: " + map.get("pride"));;
        System.out.println("Frequency of prejudice: " + map.get("prejudice"));;
    }
}
