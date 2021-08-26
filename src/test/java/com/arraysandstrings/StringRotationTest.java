package com.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {

   @Test
   public void rotationCheck() {
      String s1 = "waterbottle";
      String s2 = "erbottlewat";

      boolean isRotate = StringRotation.isRotation(s1, s2);
      Assert.assertTrue(isRotate);


      s1 = "abcde";
      s2 = "tdeab";
      isRotate = StringRotation.isRotation(s1, s2);
      Assert.assertFalse(isRotate);

   }
}
