package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
 *
 * input
 * String = "aabdec", pattern = "abc"
 *
 * output =  "abdec"
 *
 * Solution
 *
 * 1. We will keep a running count of every matching instance of a character.
 * 2. Whenever we have matched all the characters, we will try to shrink the window from the
 *    beginning, keeping track of the smallest substring that has all the matching characters.
 * 3. We will stop the shrinking process as soon as we remove a matched character from the sliding
 *    window. One thing to note here is that we could have redundant matching characters, e.g., we
 *    might have two ‘a’ in the sliding window when we only need one ‘a’. In that case, when we
 *    encounter the first ‘a’, we will simply shrink the window without decrementing the matched
 *    count. We will decrement the matched count when the second ‘a’ goes out of the window.
 *
 */
public class SmallestWindowSubstring {
    public static void main(String[] args) {
        String str = "aabdec", pattern = "abc";
        String subString = findSmallestSubstring(str, pattern);
        System.out.println(subString);
    }

    private static String findSmallestSubstring(String str, String pattern) {
        // Step 1: Frequency map for pattern
        Map<Character, Integer> map = new HashMap<>();
        if (str.length() < pattern.length()) return "";
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0, matched = 0, minLength = str.length() + 1, subStringStart = 0;
        // Step 2: Expand the window
        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);

            // If char count matches pattern's count, increment matched
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    matched++;
                }
            }

            // Step 3: Try to shrink from the left when valid
            while (matched == map.size()) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    subStringStart = start;
                }

                char startChar = str.charAt(start);
                start++;
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        matched--;
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }
            }
        }
        if (minLength > str.length()) return "";

        return str.substring(subStringStart, subStringStart + minLength);
    }
}
