package com;

import java.util.Random;

public class MaxHeapTest {
    private static void testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for(int num: testData) {
                maxHeap.add(num);
            }
        }

        int[] sortedArr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            sortedArr[i] = maxHeap.extractMax();
        }

        // 检测堆取出的元素是否降序
        for (int i = 1; i < testData.length; i++) {
            if(sortedArr[i - 1] < sortedArr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        long endTime = System.nanoTime();
        System.out.println((isHeapify ? "Heapify" : "Add") + " cost time: " + (endTime - startTime) / 10_0000_0000.0 + " s");

    }

    public static void main(String[] args) {
        int n = 100_0000;
        Integer[] testData = new Integer[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        testHeap(testData, false);
        testHeap(testData, true);
    }
}
