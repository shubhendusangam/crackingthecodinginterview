package com.practicealgo;

import org.junit.Assert;
import org.junit.Test;

public class StringCompressionTest {

   @Test
   public void stringCompression() {
      String str = "aaabccdddd";
      String actualString = StringCompression.stringCompression(str);
      String expectedString = "a3b1c2d4";
      Assert.assertEquals(actualString, expectedString);

      str = "abcd";
      actualString = StringCompression.stringCompression(str);
      expectedString = "abcd";
      Assert.assertEquals(actualString, expectedString);

   }
}
