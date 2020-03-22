package com;

import java.util.Random;

public class MaxHeapTest {
    public static void main(String[] args) {
        int n = 100_0000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] sortedArr = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArr[i] = maxHeap.extractMax();
        }
        // 检测堆取出的元素是否降序
        for (int i = 1; i < n; i++) {
            if(sortedArr[i - 1] < sortedArr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
    }
}
