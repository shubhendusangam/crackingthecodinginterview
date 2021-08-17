package com.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

public class URLifyTest {
   @Test
   public void prepareUrlIfy() {
      String replaceString = "%20";
      String actualResult = URLify.urlIfy("Mr John Smith", replaceString);
      Assert.assertEquals("Mr%20John%20Smith", actualResult);
   }
}
