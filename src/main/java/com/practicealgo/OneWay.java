package com.practicealgo;
/*
*
* Given two strings, write a function to check if they are one edit (or zero edits) away.
*
* EXAMPLE
      pale, ple -> true
      pales, pale -> true
      pale, bale -> true
      pale, bae -> false
*
* */

public class OneWay {

   public static boolean oneEditCheck(String s1, String s2) {
      if (s1.length() == s2.length()) {
         return oneEditReplace(s1, s2);
      } else if(s1.length() - 1 == s2.length()) {
         return oneEditInsert(s2, s1);
      } else if(s1.length() +1  == s2.length()) {
         return oneEditInsert(s1, s2);
      }
      return false;
   }

   private static boolean oneEditReplace(String s1, String s2) {
      boolean foundDifference = false;
      for (int i = 0; i < s1.length(); i++) {
         if (s1.charAt(i) != s2.charAt(i) ) {
            if (foundDifference) {
               return false;
            }
            foundDifference = true;
         }
      }
      return foundDifference;
   }

   private static boolean oneEditInsert(String s1, String s2) {
      int index1 = 0, index2 = 0;
      while (index1 < s1.length() && index2 < s2.length()) {
         if (s1.charAt(index1) != s2.charAt(index2)) {
            if (index1 != index2) {
               return false;
            }
         } else {
            index1++;
         }
         index2++;
      }
      return true;
   }
}
