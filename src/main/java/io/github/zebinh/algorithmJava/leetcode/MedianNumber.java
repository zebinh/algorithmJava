package io.github.zebinh.algorithmJava.leetcode;

public class MedianNumber {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longArray = nums1.length > nums2.length ? nums1 : nums2;
        int[] shortArray = nums1.length > nums2.length ? nums2 : nums1;
        int left = 0, right = shortArray.length;

        while (left <= right) {
            int i  = (left + right) / 2;
            int j = (longArray.length + shortArray.length + 1) / 2 - i;
            if (i < right && shortArray[i] < longArray[j-1]) {
                left = i + 1;
            }else if(i > left && shortArray[i-1] > longArray[j]) {
                right = i - 1;
            }else {
                int maxLeft = i == 0 ? longArray[j-1] :
                        j == 0 ? shortArray[i - 1] :
                                shortArray[i-1] > longArray[j-1] ? shortArray[i-1] : longArray[j-1];
                if ( (longArray.length + shortArray.length) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = i == shortArray.length ? longArray[j] :
                        j == longArray.length ? shortArray[i] :
                                shortArray[i] < longArray[j] ? shortArray[i] : longArray[j];
                return (maxLeft+minRight) / 2.0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
