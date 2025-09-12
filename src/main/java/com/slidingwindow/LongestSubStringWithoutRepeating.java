package com.slidingwindow;

import java.util.*;

/*
* Given a string, find the length of the longest substring without repeating characters.
* Example 1:
* Input: "abcabcbb"
* Output: 3
* Explanation: The answer is "abc", with the length of 3.

* Example 2:
* Input: "bbbbb"
* Output: 1
* Explanation: The answer is "b", with the length of 1.

* Example 3:
* Input: "pwwkew"
* Output: 3
* Explanation: The answer is "wke", with the length of 3.
* Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*
* */
public class LongestSubStringWithoutRepeating {

    public static void main(String[] args) {
        String str = "pwwkew";
        char[] charArray = str.toCharArray();
        List<Character> map = new ArrayList<>();
        StringBuilder finalOutput = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (char c : charArray) {
            if (!map.isEmpty() && map.contains(c)) {
                if (!finalOutput.isEmpty() && finalOutput.length() < builder.length()) {
                    finalOutput.append(builder);
                }
                map.clear();
                builder = new StringBuilder();
            }
            builder.append(c);
            map.add(c);
        }
        System.out.println(finalOutput);
    }
}
