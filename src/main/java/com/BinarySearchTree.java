package com;

public class BinarySearchTree<T extends Comparable> {
    public class Node {
        T value;
        Node left, right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T e) {
        root = add(root, e);
    }

    private Node add(Node node, T e) {
        if (node == null) {
            size += 1;
            return new Node(e);
        }
        int compareResult = e.compareTo(node.value);
        if (compareResult < 0) {
            node.left = add(node.left, e);
        } else if (compareResult > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(T e) {
        return contains(root, e);
    }

    private boolean contains(Node node, T e) {
        int compareResult = e.compareTo(node.value);
        if (compareResult == 0) {
            return true;
        }
        if (compareResult < 0) {
            return contains(node.left, e);
        }
        return contains(node.right, e);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.value);
    }

    /**
     * 后序遍历
     * 后序遍历的应用：为二分搜索树释放内存
     */
    public void postOrder() {
        postOrder(root);
    }
}
