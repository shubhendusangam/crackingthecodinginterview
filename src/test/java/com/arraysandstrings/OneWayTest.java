package com.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

public class OneWayTest {

   @Test
   public void oneWayTest() {
      String s1 = "abcd";
      String s2 = "abcr";
      boolean checkOneEdit = OneWay.oneEditCheck(s1, s2);
      Assert.assertTrue(checkOneEdit);

      s1 = "abc";
      s2 = "dbc";
      checkOneEdit = OneWay.oneEditCheck(s1, s2);
      Assert.assertTrue(checkOneEdit);

      s1 = "abcd";
      s2 = "ddcd";
      checkOneEdit = OneWay.oneEditCheck(s1, s2);
      Assert.assertFalse(checkOneEdit);

   }
}
