package com.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct
 * characters.
 * You can assume that K is less than or equal to the length of the given string.
 *
 *
 * Solution
 *
 * Initialize:
 *     start = 0
 *     maxLength = 0
 *     charFrequencyMap = {}
 *
 * Iterate end from 0 to end of string:
 *
 *     Add the current character to the map and update its count.
 *     If the map size (distinct chars) > size:
 *     Shrink the window from the left (start++) until charFrequencyMap size ≤ size.
 *     Update maxLength with the current window size.
 */
public class LongestSubStringWithKthDistinct {
    public static void main(String[] args) {
        String str = "araaci";
        int size = 2;
        int result = findLongestKthSubString(str, size);
        System.out.println(result);
    }

    public static int findLongestKthSubString(String str, int size) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);

            while (charFrequencyMap.size() > size) {
                char ch = str.charAt(start);
                charFrequencyMap.put(ch, charFrequencyMap.get(ch) - 1);
                if (charFrequencyMap.get(ch) == 0) {
                    charFrequencyMap.remove(ch);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
