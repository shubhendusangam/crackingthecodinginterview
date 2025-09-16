package com.slidingwindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 *
 * We have:
 *     An array of 0s and 1s.
 *     We can flip at most k zeros to 1s.
 *     We want the maximum length of a contiguous subarray that contains only 1s after at most k flips.
 *
 * Solution
 *     Initialize:
 *      left = 0 → start of window
 *      max_len = 0 → result
 *      zero_count = 0 → number of zeros in current window
 *
 *    Iterate over right from 0 to n-1:
 *      If arr[right] == 0, increment zero_count.
 *     While zero_count > k:
 *         If arr[left] == 0, decrement zero_count.
 *         Move left forward (left += 1).
 *     Update max_len = max(max_len, right - left + 1).
 *   Return max_len
 *
 *
 *
 *  How This Works
 *
 *     Track the best window:
 *         bestStart stores where the longest valid window begins.
 *         maxLen stores its length.
 *
 *     Sliding window:
 *         Expand right pointer.
 *         If zeros exceed k, shrink from left
 *
 */
public class LongestSubArrayReplace0sWith1s {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 0, 0, 1, 1, 0, 1};
        int size = 2;
        int result = findLongestSubArray(array, size);
        System.out.println(result);
    }

    private static int findLongestSubArray(int[] array, int size) {
        int windowStart = 0, zeroCount = 0, maxLength = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            // increase zeros count in current window
            if (array[windowEnd] == 0) {
                zeroCount++;
            }

            // shrink current window till zeros count less than size
            while (zeroCount > size) {
                if (array[windowStart] == 0) {
                    zeroCount--;
                }
                windowStart++;
            }

            // maximum length
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
