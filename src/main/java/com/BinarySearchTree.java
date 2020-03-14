package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // 找到最小值
    public T minimun() {
        if(size == 0) {
            throw new IllegalArgumentException("Tree is empty!");
        }
        Node min = root;
        while(min.left != null) {
            min = min.left;
        }
        return min.value;
    }

    // 找到最大值
    public T maximun() {
        if(size == 0) {
            throw new IllegalArgumentException("Tree is empty!");
        }
        Node max = root;
        while(max.right != null) {
            max = max.right;
        }
        return max.value;
    }

    // 删除掉以node为根的二分搜索树的最小节点
    // 返回删除后新的二分搜索树的根
    private Node removeMin(Node node) {
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除最小元素
    public T removeMin() {
        T min = minimun();
        root = removeMin(root);
        return min;
    }

    // 删除掉以node为根的二分搜索树的最大节点
    // 返回删除后新的二分搜索树的根
    private Node removeMax(Node node) {
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 删除最大元素
    public T removeMax() {
        T min = minimun();
        root = removeMax(root);
        return min;
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

    /**
     * 前序遍历（非递归）
     */
    public void preOrderNoRecursion() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.value);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
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

    /**
     * 层序遍历（广度优先遍历）
     * 能够更快找到想要的元素，一般用于搜寻，而不是遍历
     */
    public void LevelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.value);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
