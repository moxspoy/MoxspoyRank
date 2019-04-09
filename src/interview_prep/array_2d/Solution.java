package interview_prep.array_2d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {


    static boolean isConstraintPassed (int[][] arr) {

        boolean isElementOutConstraint = false;
        final int arrLength = arr.length;
        final int minLimit = -9;
        final int maxLimit = 9;

        //constraint
        if (arrLength >= 0 && arrLength <= 6) {

            outerLoop:
            for (int i = 0; i < arrLength; i++) {
                for (int j = 0; j < arrLength; j++) {

                    if (arr[i][j] < minLimit) {
                        //There are element out of limit
                        isElementOutConstraint = true;
                        break outerLoop;
                    } else {
                        if (arr[i][j] > maxLimit) {
                            //There are element out of limit
                            isElementOutConstraint = true;
                            break outerLoop;
                        }
                    }

                }
            }
        }

        return  !isElementOutConstraint;

    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        ArrayList<Integer> sumOfEachIterations = new ArrayList<>();
        final int numberOfIteration = 4, numberOfSubArrayRow = 3;

        if (isConstraintPassed(arr)) {

            //if all element within constrant, then execute iteration
                for (int i = 0; i < numberOfIteration; i++) {
                    for (int j = 0; j < numberOfIteration; j++) {

                        System.out.println("Titik tengah nya ada di arr[" + (i+1) + "," + (j+1) + "] is " + arr[i+1][j+1]);

                        System.out.println("i: " + i + ", j: " + j);

                        //subarray
                        int sumOfEachElement = 0;
                        for (int k = 0; k < numberOfSubArrayRow; k++) {

                            if ( k % 2 == 0) {
                                for (int l = 0; l < numberOfSubArrayRow; l++) {
                                    int m = k+i;
                                    int n = l+j;
                                    sumOfEachElement += arr[m][n];
                                    System.out.print("baris genap: arr[" + (m) + "," + (n) + "] is " + arr[m][n] + ", ");
                                    //System.out.print("baris genap: arr[" + (m) + "," + (n) + "], ");
                                }
                            } else {
                                sumOfEachElement += arr[i+1][j+1];
                                System.out.println("baris ganjil");
                            }
                        }

                        System.out.println("\nsumOfEachElement is " + sumOfEachElement + "\n");
                        sumOfEachIterations.add(sumOfEachElement);
                    }
                    System.out.println("=====================");
                }
            }

        //find max element
        int maxValue = Collections.max(sumOfEachIterations);
        System.out.println("Final result: " + maxValue);
        return maxValue;
        //self
    }



    public static void main (String[] ar) {

        int[][] arrTrue = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 3},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0},
        };

        hourglassSum(arrTrue);

        /*
        int[][] arrTrue = {
                {1, 1, 1, 1, 1, 1},
                {1, 4, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {4, 5, 8, 1, 2, 3},
                {4, 5, 6, 1, 2, 3},
                {4, 5, 6, 1, 2, -6},
        };

        //hourglassSum(arrTrue);


        int[][] arrFalse1 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0},
        };
        //hourglassSum(arrFalse1);


        int[][] arrFalse2 = {
                {-10, 2, 3, 1, 2, 3},
                {4, 5, 6, 1, 2, 3},
                {4, 5, 6, 1, 2, 3},
                {4, 5, 8, 1, 2, 3},
                {4, 5, 6, 1, 2, 3},
                {4, 5, 6, 1, 2, 8},
        };

        hourglassSum(arrFalse1);
        hourglassSum(arrFalse2);
        */
    }
}
