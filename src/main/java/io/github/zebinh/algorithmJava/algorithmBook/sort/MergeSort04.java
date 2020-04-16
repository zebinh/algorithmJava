package io.github.zebinh.algorithmJava.algorithmBook.sort;


/**
 * 归并排序
 * @author zebinh
 * @date 2020年4月15日 22点13分
 */
public class MergeSort04 {


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
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid+1, hi);
        merge(nums, lo, mid, hi);
    }

    public static void merge(int[] nums, int lo, int mid, int hi) {
        int tmp[] = new int[nums.length];
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid){
                tmp[k] = nums[j++];
            }else if(j > hi){
                tmp[k] = nums[i++];
            }else if(nums[i] < nums[j]) {
                tmp[k] = nums[i++];
            }else {
                tmp[k] = nums[j++];
            }
        }
        for (int k = lo; k <= hi; k++) {
            nums[k] = tmp[k];
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
        int[] nums = new int[]{-1,2,-8,-10};
        sortArray(nums);
        // 打印结果
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
