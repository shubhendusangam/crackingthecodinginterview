package com.arraysandstrings;

/*
*
* Given a string, write a function to check if it is a permutation of a palindrome.
*
* */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
   public static boolean palindromePermutation(String phrase) {
      Map<Character, Integer> characterCount = getCharacterCount(phrase.toLowerCase());
      boolean isEvenString = false;
      if (phrase.length() % 2 == 0) {
         isEvenString = true;
      }
      return checkOddEvenCount(characterCount.values(), isEvenString);
   }

   private static boolean checkOddEvenCount(Collection<Integer> characterCount, boolean isEven) {
      int count = 0;
      for (Integer evenCount : characterCount) {
         if (evenCount % 2 != 0) {
            if (isEven) return false;
            else {
               count++;
               if (count > 1) return false;
            }
         }
      }
      return true;
   }

   private static Map<Character, Integer> getCharacterCount(String phrase) {
      char[] chars = phrase.toCharArray();
      Map<Character, Integer> charOccurrence = new HashMap<>();
      for (Character ch : chars) {
         if (charOccurrence.containsKey(ch)) {
            charOccurrence.put(ch, charOccurrence.get(ch) + 1);
         } else {
            charOccurrence.put(ch, 1);
         }
      }
      return charOccurrence;
   }
}
