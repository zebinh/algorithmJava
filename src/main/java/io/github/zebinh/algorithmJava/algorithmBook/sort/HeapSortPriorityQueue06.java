package io.github.zebinh.algorithmJava.algorithmBook.sort;


import java.util.PriorityQueue;

/**
 * 堆排序 - 使用Java的优先队列
 * @author zebinh
 * @date 2020年4月15日 22点13分
 */
public class HeapSortPriorityQueue06 {


    /**
     * leetcode中的模板方法
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.poll();
        }
        return nums;
    }

    /**
     * 交换两个数的工具方法
     * @param nums
     * @param a
     * @param b
     */
    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{5, 2, 3, 1};
        sortArray(nums);
        // 打印结果
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
