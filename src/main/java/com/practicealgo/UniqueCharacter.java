package com.practicealgo;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacter {

   public static boolean isUniqueCharacterByArray(String uniqueChar) {
      if (uniqueChar.length() > 128) return false;

      boolean[] char_set = new boolean[128];
      for (int i = 0; i < uniqueChar.length(); i++) {
         int index = uniqueChar.charAt(i);
         if (char_set[index]) {
            return false;
         }
         char_set[index] = true;
      }
      return true;
   }

   public static boolean isUniqueCharacterByMap(String isUniqueChar) {
      Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
      char[] charArray = isUniqueChar.toCharArray();
      boolean isUniqueFlag = true;
      for (char ch : charArray) {
         if (charCountMap.containsKey(ch)) {
            isUniqueFlag = false;
            break;
         } else {
            charCountMap.put(ch, 1);
         }
      }
      return isUniqueFlag;
   }
}
