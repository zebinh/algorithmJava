package io.github.zebinh.algorithmJava.algorithmBook.search;

/**
 * 二分查找 - 红宝书
 */
public class BinarySearch01  {


    public static int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                return mid;
            }else if (target < nums[mid]){
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{-9, -7, -1, 0, 1, 3, 5, 7, 8, 9, 10, 15};
        System.out.println(search(nums, 7));
    }
}