package com.practicealgo;
/*
*
* replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,
* and that you are given the "true" length of the string.
*
* */
public class URLify {
   public static String urlIfy(String string, String replaceSpace) {
      return string.trim().replaceAll("\\s", replaceSpace);
   }
}
