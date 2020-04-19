package io.github.zebinh.algorithmJava.algorithmBook.search;

import java.util.LinkedList;
import java.util.Queue;
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
//        Queue<BST.Node> q = new LinkedList<>();
//        q.offer(root);
//        while(q.size() > 0) {
//            BST.Node node = q.poll();
//            System.out.print(node.value + ", ");
//            if (node.left != null){
//                q.offer(node.left);
//            }
//            if (node.right != null){
//                q.offer(node.right);
//            }
//        }

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
            node.right.color = true;
        }
    }


    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{-9, -7, -1, 0, 1, 3, 5, 7, 8, 9, 10, 15};
        System.out.println(search(nums, 2));
    }
}