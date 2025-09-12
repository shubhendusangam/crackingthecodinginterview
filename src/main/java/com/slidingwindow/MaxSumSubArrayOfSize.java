package com.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k’ , find the maximum sum of any
 * contiguous subarray of size ‘k’
 */
public class MaxSumSubArrayOfSize {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int size = 3;
        int result = findMaxSumSubArray(array, size);
        System.out.println(result);
    }

    private static int findMaxSumSubArray(int[] array, int size) {
        int windowSum = 0;
        int start = 0;
        int maxSum = 0;
        for (int end = 0; end < array.length; end++) {
            windowSum += array[end];

            if (end >= size - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= array[start];
                start++;
            }
        }
        return maxSum;
    }
}
