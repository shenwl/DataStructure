package com;

import java.util.ArrayList;

public class MapTest {
    private static double testMap(Map<String, Integer> map) {
        ArrayList<String> words = new ArrayList<>();

        long startTime = System.nanoTime();


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
        System.out.println("Frequency of prejudice: " + map.get("prejudice"));

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
    public static void main(String[] args) {
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        BSTMap<String, Integer> bstMap = new BSTMap<>();

        System.out.println("LinkedListMap cost time: " + testMap(linkedListMap) + " s"); // 11.14s
        System.out.println("BSTMap cost time: " + testMap(bstMap) + " s"); // 0.09s
    }
}
