package com;

public interface Queue<T> {
    void enqueue(T e);
    T dequeue();
    T getFront();
    int getSize();
    boolean isEmpty();
}
