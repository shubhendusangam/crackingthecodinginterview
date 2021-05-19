package com.practicealgo;

import java.util.Arrays;

public class PermutationCheck {
   public static void main(String[] args) {
      String permutationS1 = "temp";
      String permutationS2 = "mept";
      boolean isPermutation = permutationCheck(permutationS1, permutationS2);
      System.out.println(isPermutation);
   }

   private static boolean permutationCheck(String permutationStr1, String permutationStr2) {
      if (permutationStr1.length() != permutationStr2.length()) return false;

      char[] content1 = permutationStr1.toCharArray();
      char[] content2 = permutationStr2.toCharArray();

      Arrays.sort(content1);
      Arrays.sort(content2);

      return new String(content1).equals(new String(content2));
   }
}
