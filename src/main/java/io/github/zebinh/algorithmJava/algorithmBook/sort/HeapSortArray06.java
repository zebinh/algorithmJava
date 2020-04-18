package io.github.zebinh.algorithmJava.algorithmBook.sort;


/**
 * 堆排序
 * @author zebinh
 * @date 2020年4月15日 22点13分
 */
public class HeapSortArray06 {


    /**
     * leetcode中的模板方法
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        int[] tmp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++){
            tmp[i+1] = nums[i];
        }


        for (int i = 1; i < tmp.length; i++) {
            swim(tmp, i);
        }
        for (int i = tmp.length-1; i >1; i--) {
            swap(tmp, 1, i);
            sink(tmp, i-1);
        }

        // 搬运回去
        for (int i = 0; i < nums.length; i++){
            nums[i] = tmp[i+1];
        }
        return nums;
    }


    public static void swim(int[] nums, int i) {

        while(i > 1 && nums[i] > nums[i/2]) {
            swap(nums, i, i/2);
            i /= 2;
        }
    }

    public static void sink(int[] nums, int end) {
        int cur = 1;
        while (cur * 2 <= end) {
            int max = cur * 2;
            if (max+1 <= end && nums[max] < nums[max+1]) {
                max = max+1;
            }
            if (nums[max] < nums[cur]){
                break;
            }
            swap(nums, max, cur);
            cur = max;
        }
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
