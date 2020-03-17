package com;

import java.util.ArrayList;

public class TreeSetTest {
    public static void main(String[] args) {
        ArrayList<String> words1 = new ArrayList<>();
        TreeSet<String> words2 = new TreeSet<>();
        FileOperation.readFile("src/Pride_and_Prejudice.txt", words1);
        System.out.println("words1 size: " + words1.size());

        for(String word: words1) {
            words2.add(word);
        }
        System.out.println("words2 size: " + words2.getSize());
    }
}
