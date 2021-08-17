package com.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import static com.arraysandstrings.ZeroMatrix.zeroMatrix;

public class ZeroMatrixTest {

   @Test
   public void zeroMatrixTest() {
      int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 0, 8},
            {9, 10, 11, 12},
            {13, 0, 15, 16}
      };
      int[][] actualMatrixResult = zeroMatrix(matrix);
      int[][] expectedMatrix = {
            {1, 0, 0, 4},
            {0, 0, 0, 0},
            {9, 0, 0, 12},
            {0, 0, 0, 0}
      };
      Assert.assertArrayEquals(expectedMatrix, actualMatrixResult);
   }
}
