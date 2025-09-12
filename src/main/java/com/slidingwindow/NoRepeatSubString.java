package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters.
 *
 *
 * Solution
 *
 *     Use two pointers: start (window start) and end (window end).
 *     Use a Map<Character, Integer> to store the last index of each character we’ve seen.
 *     Expand end to include new characters.
 *     If we see a duplicate, move start to one position after the last occurrence of that character.
 *     Keep track of the maximum window size.
 */
public class NoRepeatSubString {
    public static void main(String[] args) {
        String str = "aabccbb";
        int result = findNoRepeatSubString(str);
        System.out.println(result);
    }

    private static int findNoRepeatSubString(String str) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);

            if (characterIntegerMap.containsKey(ch)) {
                start = Math.max(start, characterIntegerMap.get(ch) + 1);
            }

            characterIntegerMap.put(ch, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
