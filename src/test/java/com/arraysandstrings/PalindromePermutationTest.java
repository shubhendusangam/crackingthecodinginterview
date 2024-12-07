package com.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePermutationTest {
    @Test
    public void checkStringPalindromePermutation() {
        String testPhrase = "TactCoa";
        boolean actualResult = PalindromePermutation.palindromePermutation(testPhrase);
        Assert.assertTrue(actualResult);
    }
}
