package io.github.zebinh.algorithmJava.algorithmBook.sort;


/**
 * 希尔排序
 * @author zebinh
 * @date 2020年4月15日 22点13分
 */
public class ShellSort03 {


    /**
     * leetcode中的模板方法
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {

        for (int step = nums.length/2; step > 0; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                for (int j = i; j >= step; j -= step) {
                    if (nums[j] < nums[j - step]) {
                        swap(nums,j, j-step);
                    }else {
                        break;
                    }
                }
            }
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
