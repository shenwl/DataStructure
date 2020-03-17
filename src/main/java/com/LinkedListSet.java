package com;

import java.util.LinkedList;

public class LinkedListSet<T> implements Set<T> {
    LinkedList<T> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(T e) {
        if (linkedList.contains(e)) {
            return;
        }
        linkedList.add(e);
    }

    @Override
    public void remove(T e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(T e) {
        return linkedList.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.size();
    }
}
