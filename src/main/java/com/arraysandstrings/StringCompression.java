package com.arraysandstrings;
/*
*
* String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
* For example, the string aabcccccaaa would become a2blc5a3.
* If the "compressed" string would not become smaller than the original string, your method should return the original string.
* You can assume the string has only uppercase and lowercase letters (a - z).
*
*
* */
public class StringCompression {

   public static String stringCompression(String str) {
      if (str.isEmpty()) return str;
      StringBuilder compressString = new StringBuilder();
      int j = 0;
      for (int i = 0; j < str.length(); ) {
         int counter = 0;
         char chr = str.charAt(i);
         for (j = i; j < str.length(); j++) {
            if (chr == str.charAt(j)) {
               counter++;
            } else {
               i = j;
               break;
            }
         }
         compressString.append(chr).append(counter);
         if (i+1 > str.length()) break;
      }
      if (str.length() < compressString.length()) return str;
      return String.valueOf(compressString);
   }
}
