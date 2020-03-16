package com;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        //////////////////
        //      5       //
        // 3        6   //
        //2 4         8 //
        //////////////////
        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        bst.add(8);

        bst.preOrder();
//        System.out.println("---------");
//        bst.preOrderNoRecursion();
//        System.out.println("---------");
//        bst.inOrder();
//        System.out.println("---------");
//        bst.postOrder();
//        System.out.println("---------");
//        bst.LevelOrder();
//        System.out.println("---------");
//        System.out.println(bst.removeMin());
//        System.out.println("---------");
//        System.out.println(bst.removeMax());
        System.out.println("---------");
        bst.remove(4);
        System.out.println("---------");
        bst.preOrder();
    }
}
