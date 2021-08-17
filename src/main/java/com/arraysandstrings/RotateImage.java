package com.arraysandstrings;

/*
* Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
* write a method to rotate the image by 90 degrees
*/

public class RotateImage {

   public static int[][]  rotate90Clockwise(int[][] matrix, int n) {
      // transpose of a matrix
      matrix = transposeMatrix(matrix, n);

      // reverse of transpose matrix
      matrix = reverseMatrix90ClockWise(matrix, n);

      display(matrix, n);

      return matrix;
   }

   public static int[][]  rotate90AntiClockwise(int[][] matrix, int n) {
      // transpose of a matrix
      matrix = transposeMatrix(matrix, n);

      // reverse of transpose matrix
      matrix = reverseMatrix90AntiClockWise(matrix, n);

      display(matrix, n);

      return matrix;
   }

   // matrix in place rotation
   public static int[][] rotate(int[][] matrix, int n) {
      for (int layer = 0; layer < n/2; layer++) {
         int first = layer;
         int last = n - 1 - layer;
         for (int i = first; i < last; i++) {
            int offset = i -first;

            // save top
            int top = matrix[first][i];

            // left -> top
            matrix[first][i] = matrix[last-offset][first];

            // bottom -> left
            matrix[last-offset][first] = matrix[last][last-offset];

            // right to bottom
            matrix[last][last-offset] = matrix[i][last];

            // top to right
            matrix[i][last] = top;
         }
      }
      return matrix;
   }

   private static int[][] reverseMatrix90AntiClockWise(int[][] matrix, int n) {
      for (int i = 0; i < n/2; i++) {
         for (int j = 0; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n-i-1][j];
            matrix[n-i-1][j] = temp;
         }
      }
      return matrix;
   }

   private static int[][] reverseMatrix90ClockWise(int[][] matrix, int n) {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n/2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n-j-1];
            matrix[i][n-j-1] = temp;
         }
      }
      return matrix;
   }

   private static int[][] transposeMatrix(int[][] matrix, int n) {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < i; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
      }
      return matrix;
   }

   private static void display(int[][] matrix, int n){
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            System.out.print(matrix[i][j] + "   ");
         }
         System.out.println();
      }
   }
}
