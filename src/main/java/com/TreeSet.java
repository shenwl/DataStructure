package com;

public class TreeSet<T extends Comparable> implements Set<T> {
    private BinarySearchTree<T> bst;

    public TreeSet() {
        this.bst = new BinarySearchTree<T>();
    }

    @Override
    public void add(T e) {
        bst.add(e);
    }

    @Override
    public void remove(T e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(T e) {
        return bst.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.size();
    }
}
