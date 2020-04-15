package io.github.zebinh.algorithmJava.algorithmBook.sort;


/**
 * 选择排序
 * @author zebinh
 * @date 2020年4月15日 22点13分
 */
public class SelectSort01 {


    /**
     * leetcode中的模板方法
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
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
        int[] nums = new int[]{-1,2,-8,-10};
        sortArray(nums);
        // 打印结果
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
