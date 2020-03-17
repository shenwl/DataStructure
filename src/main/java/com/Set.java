package com;

public interface Set<T> {
    void add(T e);
    void remove(T e);
    boolean contains(T e);
    boolean isEmpty();
    int getSize();
}
