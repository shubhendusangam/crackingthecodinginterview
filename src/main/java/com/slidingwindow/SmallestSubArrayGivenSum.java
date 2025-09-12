package com.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0 if no such subarray exists.
 * <p>
 *
 * Solution
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * <p>
 * Idea
 *
 *  Use two pointers: windowStart and windowEnd.
 *  Expand the window by moving windowEnd and adding elements to windowSum.
 *  Whenever windowSum >= S, try to shrink the window from the left to find the smallest possible length.
 *  Keep track of the minimum length found.
 */
public class SmallestSubArrayGivenSum {
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 6, 5, 2, 3, 2, 8, 10, 6};
        int size = 12;
        int result = findSmallestSubArray(array, size);
        System.out.println(result);
    }

    private static int findSmallestSubArray(int[] array, int size) {
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;

        for (int end = 0; end < array.length; end++) {
            windowSum += array[end];

            while(windowSum >= size) {
                minLength = Math.min(minLength, end - start + 1);
                windowSum -= array[start];
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
