package io.github.zebinh.algorithmJava.algorithmBook.sort;


/**
 * 快速排序
 * @author zebinh
 * @date 2020年4月15日 22点13分
 */
public class QuickSort05 {


    /**
     * leetcode中的模板方法
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {

        sort(nums, 0, nums.length-1);
        return nums;
    }

    public static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = partition(nums, lo, hi);
        sort(nums, lo, mid-1);
        sort(nums, mid+1, hi);
    }

    public static int partition(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return lo;
        }
        int i = lo;
        int j = hi;
        int pivot = nums[hi];
        while(i < j) {
            while (nums[i] < pivot && i < j){
                i++;
            }
            while (nums[j] >= pivot && i < j){
                j--;
            }
            swap(nums, i, j);
        }
        swap(nums, i, hi);
        return i;
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
