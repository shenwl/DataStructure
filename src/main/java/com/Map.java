package com;

public interface Map<K, V> {
    void add(K key, V value);
    void set(K key, V newValue);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    int getSize();
    boolean isEmpty();
}
