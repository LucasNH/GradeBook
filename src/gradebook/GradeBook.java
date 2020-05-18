/*
GradeBook.java 
Created by: Lucas Noritomi-Hartwig
Created on: May 17, 2020
Last edited on: May 20, 2020
The first method of this program takes an input of a linear integer array, and
outputs the sum of it's elements. The second method takes an input of a 2D integer
array and calls the first method to sum up each row of the array and outputs a
linear  array of the sums. The third method calls takes an input of a 2D integer
array, calls the second method, and outputs the number of elements equal to or
greater than 30.
 */
package gradebook;

import java.util.Arrays;

public class GradeBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr1 = {10, 8, 9, 7, 10};
        System.out.println(gradeTotal(arr1));

        int[][] arr2D = {
            {10, 7, 8, 0},
            {10, 6, 9, 0},
            {9, 4, 7, 2},
            {10, 8, 8, 3},
            {9, 8, 8, 0},
            {10, 5, 7, 2}};
        System.out.println(Arrays.toString(classTotals(arr2D)));

        System.out.println(numPassing(arr2D));
    }

    public static int gradeTotal(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }

    public static int[] classTotals(int[][] array) {
        int[] totals = new int[4];
        for (int i = 0; i < totals.length; i++) {
            int[] grades = new int[6];
            for (int j = 0; j < array.length; j++) {
                grades[j] = array[j][i];
            }
            totals[i] += gradeTotal(grades);
        }
        return totals;
    }

    public static int numPassing(int[][] array) {
        int num = 0;
        int[] totals = classTotals(array);
        for (int i = 0; i < totals.length; i++) {
            if (totals[i] >= 30) {
                num++;
            }
        }
        return num;
    }
}
