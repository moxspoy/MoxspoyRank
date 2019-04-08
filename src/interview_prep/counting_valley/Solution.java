package interview_prep.counting_valley;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int limit = power(10,6);
        int numValleys = 0, seaLevel = 0;
        boolean underSeaLevel = false;

        if(n >= 2 && n <= limit) {
            for(int i = 0; i < n; i++) {

                if(s.charAt(i) == 'U') {
                    seaLevel++;
                } else {
                    seaLevel--;
                }

                if(!underSeaLevel && seaLevel < 0)
                {
                    numValleys++;
                    underSeaLevel = true;
                }

                if(seaLevel >= 0) {
                    underSeaLevel = false;
                }
            }
        }
        return numValleys;
    }

    static int power(int a, int b) {
       int result = a;
       for (int i = 0; i < b - 1; i++) {
           result *= a;
       }
       return result;
    }

    public static void main (String[] ar) {
        System.out.println(
                countingValleys(8, "UDDDUDUU")
        );
        System.out.println(
                power(3,3)
        );
    }
}
