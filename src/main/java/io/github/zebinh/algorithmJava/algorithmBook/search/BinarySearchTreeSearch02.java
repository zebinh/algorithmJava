package io.github.zebinh.algorithmJava.algorithmBook.search;

/**
 * 二叉查找树 - 红宝书
 */
public class BinarySearchTreeSearch02 {


    public static int search(int[] nums, int target) {
        BST bsTree = new BST();
        for (int i = 0; i < nums.length; i++) {
            bsTree.insert(nums[i]);
        }
        BST.Node root = bsTree.root;
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
            Node(Integer value){
                this.value = value;
            }
        }

        private Node root;

        public void insert(Integer value){
            root = put(root, value);
        }

        public Node put(Node node, int value){
            if(node == null){
                return new Node(value);
            }
            if (node.value > value) {
                node.left = put(node.left, value);
            }else if(node.value < value){
                node.right = put(node.right, value);
            }
            return node;
        }
    }


    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{-9, -7, -1, 0, 1, 3, 5, 7, 8, 9, 10, 15};
        System.out.println(search(nums, 99));
    }
}