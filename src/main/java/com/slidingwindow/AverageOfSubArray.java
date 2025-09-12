package com.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it
 */
public class AverageOfSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int size = 3;
        List<Integer> result = findAverageOfSubArray(array, size);
        System.out.println(result);
    }

    private static List<Integer> findAverageOfSubArray(int[] array, int size) {
        List<Integer> result = new ArrayList<>(array.length);

        int sum = 0;
        int start = 0;
        for (int end = 0; end < array.length; end++) {

            sum += array[end];

            if (end >= size - 1) {
                result.add(sum / size);
                sum -= array[start];
                start++;
            }
        }
        return  result;
    }
}
