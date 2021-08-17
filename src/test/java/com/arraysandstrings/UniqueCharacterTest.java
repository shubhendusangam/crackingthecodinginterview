package com.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

public class UniqueCharacterTest {

   @Test
   public void isUniqueCharacterByArrayTest() {
      String testString = "temp";
      boolean uniqueCharacterByArray = UniqueCharacter.isUniqueCharacterByArray(testString);
      Assert.assertTrue(uniqueCharacterByArray);
   }

   @Test
   public void isUniqueCharacterByMapTest() {
      String testString = "temp";
      boolean uniqueCharacterByArray = UniqueCharacter.isUniqueCharacterByMap(testString);
      Assert.assertTrue(uniqueCharacterByArray);
   }
}
