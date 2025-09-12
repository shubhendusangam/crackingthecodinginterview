package com.slidingwindow;

/**
 *
 * Given an array of characters where each character represents a fruit tree, you are given two
 * baskets, and your goal is to put the maximum number of fruits in each basket. The only
 * restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but you can’t skip a tree once you have started. You will pick one
 * fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit
 * type.
 *
 * Write a function to return the maximum number of fruits in both baskets.
 *
 *
 *This is essentially:
 *
 *     we need to find the length of the longest subarray with no more than two distinct characters (or fruit types!)
 *          or
 *     Find the longest contiguous subarray containing at most 2 distinct characters.
 *
 * We can solve it using the sliding window technique:
 *
 *     Use two pointers (start and end) to represent the current window.
 *     Use a Map<Character, Integer> to store the count of each fruit in the window.
 *     Expand end to include more fruits.
 *     If the map has more than 2 fruit types, shrink from start until only 2 remain.
 *     Track the maximum window size.
 *
 *
 */
public class FruitsIntoBaskets {
    public static void main(String[] args) {
        String str = "ABCBBC";
        int size = 2;
        int result = LongestSubStringWithKthDistinct.findLongestKthSubString(str, size);
        System.out.println(result);
    }
}
