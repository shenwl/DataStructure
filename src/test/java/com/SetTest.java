package com;

import java.util.ArrayList;

public class SetTest {
    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(filename, words);

        System.out.println("total words: " + words.size());

        for(String word: words) {
            set.add(word);
        }

        System.out.println("diff words: " + set.getSize());


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }
    public static void main(String[] args) {
        String file = "src/Pride_and_Prejudice.txt";

        // TreeSet
        TreeSet<String> bstSet = new TreeSet<>();
        // LinkedListSet
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();

        double time1 = testSet(bstSet, file);
        double time2 = testSet(linkedListSet, file);

        System.out.println("bstSet test time(s)" + time1);
        System.out.println("linkedListSet test time(s)" + time2);
    }
}
