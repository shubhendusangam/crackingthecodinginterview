package com.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

public class PermutationCheckTest {
   private static String string1 = "temp";
   private static String string2 = "mept";

   @Test
   public void permutationCheck() {
      boolean prCheck = PermutationCheck.permutationCheck(string1, string2);
      Assert.assertTrue(prCheck);
   }
}
