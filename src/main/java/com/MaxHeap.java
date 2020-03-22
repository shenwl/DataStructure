package com;

import java.util.ArrayList;

/**
 * 最大堆的原理 https://www.yuque.com/shenwl/kb/tgt9p8
 */
public class MaxHeap<T extends Comparable<T>> {
    private class Node {
    }

    private ArrayList<T> data;

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    // 交换data中元素的位置
    private void swapDataEl(int index1, int index2) {
        T el1 = data.get(index1);
        T el2 = data.get(index2);

        data.set(index1, el2);
        data.set(index2, el1);
    }

    /**
     * 向堆中添加元素，需要按照二叉堆的规则将元素上浮到正确位置
     * 规则：堆中某个节点的值总是不大于其父节点的值
     */
    private void siftUp(int elIndex) {
        if (elIndex <= 0) {
            return;
        }
        // 大于父元素，就要上浮（与父元素交换）
        int parentIndex = parent(elIndex);
        while (data.get(parentIndex).compareTo(data.get(elIndex)) < 0) {
            swapDataEl(elIndex, parentIndex);
            elIndex = parentIndex;
            // 已经上浮到顶端
            if (elIndex == 0) {
                break;
            }
            parentIndex = parent(elIndex);
        }
    }

    public void add(T e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    /**
     * 元素和子节点对比，下沉到合适位置
     * 规则：堆中某个节点的值总是不大于其父节点的值
     */
    private void siftDown(int elIndex) {
        if (elIndex < 0 || (elIndex == size() - 1)) return;
        // 小于子元素，就要下沉（与较大的子元素交换）
        int leftIndex = left(elIndex);
        int rightIndex = right(elIndex);
        while (leftIndex < data.size()) {
            T el = data.get(elIndex);
            int compareIndex = leftIndex;
            T compareEl = data.get(leftIndex);
            // 如果存在右子节点，且大于左子节点; compareEl为子节点中的最大值
            if (rightIndex < data.size() && data.get(rightIndex).compareTo(compareEl) > 0) {
                compareEl = data.get(rightIndex);
                compareIndex = rightIndex;
            }
            if (data.get(elIndex).compareTo(compareEl) > 0) {
                break;
            }
            swapDataEl(elIndex, compareIndex);
            elIndex = compareIndex;
            leftIndex = left(elIndex);
            rightIndex = right(elIndex);
        }
    }

    /**
     * 取出最大元素
     *
     * @return T
     */
    public T extractMax() {
        T ret = findMax();

        // 从堆中取出元素，取出的是最大的，等于取出根节点（会变成两颗子树），将尾部元素当作新的根，需要重新排列树
        swapDataEl(0, size() - 1);
        data.remove(size() - 1);
        siftDown(0);

        return ret;
    }

    private T findMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("Can not findMax in empty heap!");
        }
        return data.get(0);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    public int left(int index) {
        return index * 2 + 1;
    }

    public int right(int index) {
        return index * 2 + 2;
    }
}
