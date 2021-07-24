package com.practicealgo;

import org.junit.Assert;
import org.junit.Test;

public class RotateImageTest {

   @Test
   public void rotate90Test () {
      int[][] inputMatrix =
            {
                  {1, 2, 3, 4},
                  {5, 6, 7, 8},
                  {9, 10, 11, 12},
                  {13, 14, 15, 16}
            };

      int[][] actualResult90ClockWise = RotateImage.rotate90Clockwise(inputMatrix, inputMatrix.length);
      System.out.println("-----------------------");

      int[][] expectedMatrix90ClockWise =
            {
                  {13, 9, 5, 1},
                  {14, 10, 6, 2},
                  {15, 11, 7, 3},
                  {16, 12, 8, 4}
            };
      Assert.assertArrayEquals(expectedMatrix90ClockWise, actualResult90ClockWise);

      int[][] inputMatrixx =
            {
                  {1, 2, 3, 4},
                  {5, 6, 7, 8},
                  {9, 10, 11, 12},
                  {13, 14, 15, 16}
            };

      int[][] actualResult90AntiClockWise = RotateImage.rotate90AntiClockwise(inputMatrixx, inputMatrix.length);

      int[][] expectedMatrix90AntiClockWise = {
         {
            4, 8, 12, 16
         },
         {
            3, 7, 11, 15
         },
         {
            2, 6, 10, 14
         },
         {
            1, 5, 9, 13
         }
      };
      Assert.assertArrayEquals(expectedMatrix90AntiClockWise, actualResult90AntiClockWise);

   }

}
