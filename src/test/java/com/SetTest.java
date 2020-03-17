package com;

import java.util.ArrayList;

public class SetTest {
    public static void main(String[] args) {
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("src/Pride_and_Prejudice.txt", words1);
        System.out.println("total words: " + words1.size());

        // TreeSet
        TreeSet<String> words2 = new TreeSet<>();
        // LinkedListSet
        LinkedListSet<String> words3 = new LinkedListSet<>();

        for(String word: words1) {
            words2.add(word);
            words3.add(word);
        }
        System.out.println("diff words by TreeSet: " + words2.getSize());

        System.out.println("diff words by LinkedListSet: " + words3.getSize());

    }
}
