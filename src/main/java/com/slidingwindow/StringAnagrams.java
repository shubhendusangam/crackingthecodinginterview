package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Solution
 *
 * An anagram of the pattern has the same length and same character frequency as the pattern.
 * We can:
 *    Build a frequency map of the pattern.
 *    Slide a window of size pattern.length() over the string.
 *    Track matches using a counter (matched).
 *    When all characters match, record the starting index.
 *
 */
public class StringAnagrams {
    public static void main(String[] args) {
        String str = "ppqp";
        String pattern = "pq";
        List<Integer> result = findAllAnagrams(str, pattern);
        System.out.println(result);
    }

    private static List<Integer> findAllAnagrams(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> indices = new ArrayList<>();
        if (str.length() < pattern.length()) {
            return indices;
        }

        int match = 0, start = 0;
        // Step 1: Build frequency map for the pattern
        for (char chr : pattern.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        // Step 2: Expand the sliding window
        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);

            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    match++;
                }
            }

            // Step 3: If all characters matched, record the start index
            if (match == map.size()) {
                indices.add(start);
            }

            // Step 4: Shrink the window if size exceeds pattern length
            if (end >= pattern.length() - 1) {
                char startChar = str.charAt(start);
                start++;
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        match--;
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }

            }
        }
        return indices;
    }
}
