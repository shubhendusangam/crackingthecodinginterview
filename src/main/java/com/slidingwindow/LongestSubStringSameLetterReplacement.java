package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’
 * letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * input - "aabccbb", size - 2
 * output - 5
 *
 * why ? Replace the two 'c' with 'b' to have the longest substring
 *
 * Steps
 *
 * Use a sliding window with start and end pointers.
 * Keep a frequency map of characters in the current window.
 * Track maxRepeatCount — the count of the most frequent character in the window.
 * If (window length - maxRepeatCount) > k, shrink the window from the left.
 * Update maxLength at each step.
 *
 *
 * Code explanation
 *
 * (window length) - (count of most frequent letter in window) ≤ k
 *
 * why ?
 *
 * (window length) = total characters in the current window.
 * (count of most frequent letter) = characters we don’t need to replace.
 * The rest are the ones we must replace — and that must be ≤ k.
 *
 */

public class LongestSubStringSameLetterReplacement {
    public static void main(String[] args) {
        String str = "aabccbb";
        int size = 2;
        int result = findLength(str, size);
        System.out.println(result);
    }

    private static int findLength(String str, int size) {
        int start = 0;
        int maxRepeatCount = 0;
        int maxLength = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);
            // Keep a frequency map of characters in the current window
            frequencyMap.put(endChar, frequencyMap.getOrDefault(endChar, 0) + 1);
            // the count of the most frequent character in the window
            maxRepeatCount = Math.max(maxRepeatCount, frequencyMap.get(endChar));

            while ((end - start + 1 - maxRepeatCount) > size) {
                char startChar = str.charAt(start);
                frequencyMap.put(startChar, frequencyMap.get(startChar) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}