package io.github.zebinh.algorithmJava.algorithmBook.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 二叉查找树 - 红宝书
 */
public class RedBlackBinarySearchTreeSearch03 {


    public static int search(int[] nums, int target) {
        BST bsTree = new BST();
        for (int i = 0; i < nums.length; i++) {
            bsTree.insert(nums[i]);
        }
        BST.Node root = bsTree.root;
        Queue<BST.Node> cur = new LinkedList<>();
        Queue<BST.Node> next = new LinkedList<>();
        cur.offer(root);
        while(!cur.isEmpty()) {
            BST.Node node = cur.poll();
            System.out.print(node.value + ",");
            if (node.left != null){
                next.offer(node.left);
            }
            if (node.right != null){
                next.offer(node.right);
            }
            if (cur.isEmpty()) {
                System.out.println();
                cur = next;
                next = new LinkedList<>();
            }
        }

        while(root != null){
            if (root.value == target) {
                return 1;
            }else if (root.value < target){
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return -1;
    }

    static class BST{
        class Node{
            public Integer value;
            public Node left;
            public Node right;
            public boolean color;
            Node(Integer value, Boolean color){
                this.value = value;
                this.color = color;
            }
        }

        private Node root;

        public void insert(Integer value){
            root = put(root, value);
            root.color = false;
        }

        public Node put(Node node, int value){
            if(node == null){
                return new Node(value, true);
            }
            if (node.value > value) {
                node.left = put(node.left, value);
            }else if(node.value < value){
                node.right = put(node.right, value);
            }
            if (isRed(node.right) && !isRed(node.left)){
                node = rotateLeft(node);
            }
            if (isRed(node.left) && isRed(node.left.left)){
                node = rotateRight(node);
            }
            if (isRed(node.left) && isRed(node.right)) {
                flipColor(node);
            }
            return node;
        }

        public boolean isRed(Node node){
            if (node == null){
                return false;
            }
            return node.color == true;
        }

        public Node rotateLeft(Node node){
            Node next = node.right;
            node.right = next.left;
            next.left = node;
            next.color = node.color;
            node.color = true;
            return next;
        }

        public Node rotateRight(Node node){
            Node next = node.left;
            node.left = next.right;
            next.right = node;
            next.color = node.color;
            node.color = true;
            return next;
        }

        public void flipColor(Node node) {
            node.color = true;
            node.left.color = false;
            node.right.color = false;
        }
    }


    public static void main(String[] args) {
        // 测试用例
        final int COUNT = 127;
        int [] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] nums = new int[COUNT];
//        for (int i = 0; i < COUNT; i++) {
//            nums[i] = (int)(Math.random() * 1000);
//        }
        System.out.println(search(nums, -1));
    }
}