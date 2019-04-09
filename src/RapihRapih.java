import java.util.ArrayList;
import java.util.Collections;

public class RapihRapih {
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

                    //System.out.println("Titik tengah nya ada di arr[" + (i+1) + "," + (j+1) + "] is " + arr[i+1][j+1]);
                    //System.out.println("i: " + i + ", j: " + j);

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

                    //System.out.println("\nsumOfEachElement is " + sumOfEachElement + "\n");
                    sumOfEachIterations.add(sumOfEachElement);
                }
            }
        }

        //find max element
        int maxValue = Collections.max(sumOfEachIterations);
        return maxValue;
        //self
    }
}
