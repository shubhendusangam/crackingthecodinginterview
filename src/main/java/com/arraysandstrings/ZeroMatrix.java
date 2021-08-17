package com.arraysandstrings;
/*
* if an element in an M*N matrix is 0 , its entire row and column are set to 0
*
* */
public class ZeroMatrix {
   static boolean[] rows;
   static boolean[] columns;

   public static int[][] zeroMatrix(int[][] matrix) {
      rows = new boolean[matrix.length];
      columns = new boolean[matrix[0].length];

      // check rows and columns is having zero
      for (int i = 0; i < rows.length; i++) {
         for (int j = 0; j < columns.length; j++) {
            if (matrix[i][j] == 0) {
               rows[i] = true;
               columns[j] = true;
            }
         }
      }

      // set rows zero
      for (int i = 0; i < rows.length; i++) {
         if (rows[i]) nullifyRows(matrix, i);
      }

      //set columns zero
      for (int i = 0; i < columns.length; i++) {
         if (columns[i]) nullifyColumns(matrix, i);
      }
      return matrix;
   }

   private static void nullifyColumns(int[][] matrix, int column) {
      for (int j = 0; j < rows.length; j++) {
         matrix[j][column] = 0;
      }
   }

   private static void nullifyRows(int[][] matrix, int row) {
      for (int i = 0; i < columns.length; i++) {
         matrix[row][i] = 0;
      }
   }
}
