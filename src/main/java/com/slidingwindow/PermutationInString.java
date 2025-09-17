package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 *
 * Example
 *  Permutations of "abc": "abc", "acb", "bac", "bca", "cab", "cba"
 *  "bca" exists in "oidbcaf" → return true
 *
 *
 * Solution
 *
 * Create a Map<Character, Integer> for the pattern’s character counts.
 * Use two pointers (windowStart, windowEnd) to represent the sliding window.
 * Keep a matched counter for how many characters have matched the required frequency.
 * Expand the window by adding str[windowEnd].
 * If a character’s frequency matches the pattern’s frequency, increment matched.
 * If matched == pattern.length(), return true.
 * If the window size exceeds pattern.length(), shrink from the left and adjust counts.
 * If no match found after the loop, return false.
 */
public class PermutationInString {
    public static void main(String[] args) {
        String str = "oidbcaf";
        String pattern = "abc";
        boolean result = findPermutation(str, pattern);
        System.out.println(result);
    }

    private static boolean findPermutation(String str, String pattern) {
        // Create a Map<Character, Integer> for the pattern’s character counts.
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char charAt = pattern.charAt(i);
            map.put(charAt, map.getOrDefault(charAt, 0) + 1);
        }

        // Keep a matched counter for how many characters have matched the required frequency
        int start = 0, matchedCounter = 0;
        // Expand the window by adding
        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);

            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                // character’s frequency matches the pattern’s frequency, increment matched
                if (map.get(endChar) == 0) {
                    matchedCounter++;
                }
            }

            // matched == pattern.length(), return true
            if (matchedCounter == map.size()) {
                return true;
            }

            // window size exceeds pattern.length()
            if (end >= pattern.length() - 1) {
                // shrink from the left
                char startChar = str.charAt(start);
                start++;
                // adjust counts
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        matchedCounter++;
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }
            }
        }
        // no match found after the loop, return false
        return false;
    }
}
