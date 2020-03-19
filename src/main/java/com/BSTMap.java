package com;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    private class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key) {
            this(key, null);
        }
    }

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    // 返回以node为根，对应key的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);

        if (compareResult == 0) {
            return node;
        }
        if (compareResult < 0) {
            return getNode(node.left, key);
        }
        return getNode(node.right, key);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = add(node.left, key, value);
        } else if (compareResult > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root ,key);
        if(node == null) {
            throw new IllegalArgumentException("set error: " + key + "doesn't exist!");
        }
        node.value = newValue;
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

    private Node remove(Node node, K key) {
        if(node == null) {
            return null;
        }
        int compareResult = key.compareTo((node.key));
        if(compareResult < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        if(compareResult > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        // 待删除节点左子树为null
        if(node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        // 待删除节点右子树为null
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        // 如果左右子树均不为空：
        // 用该节点右子树的最小节点作为当前节点（当前节点就删除了）
        // 删除该节点右子树的最小节点
        Node removeNode = removeMin(node.right);
        node.key = removeNode.key;
        node.value = removeNode.value;
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null) {
            root = remove(root, key);
            size --;
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
