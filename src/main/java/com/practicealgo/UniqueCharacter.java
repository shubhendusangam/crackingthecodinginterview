package com.practicealgo;

public class UniqueCharacter {
   public static void main(String[] args) {
      String uniqueChar = "temp";
      boolean uniqueCharacter = isUniqueCharacter(uniqueChar);
      System.out.println(uniqueCharacter);
   }

   private static boolean isUniqueCharacter(String uniqueChar) {
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
}
