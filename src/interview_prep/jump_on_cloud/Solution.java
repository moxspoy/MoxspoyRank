package interview_prep.jump_on_cloud;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        //input 0 0 1 0 0 1 0
        //output 4
        int limit = power(10, 2);
        int emmaPosition = 0;
        int step = 0;
        int n = c.length;
        if ( n >= 2 && n <= limit) {
            for (int i = 1; i<n; i++) {

                print("emma position: " + emmaPosition + ", i: " + i + ", next cloud is " + c[i]);
                //input 0, 0, 0, 1, 0, 0
                if (c[i] == 0) {
                    //avoid index bound while in c[i+1]
                    if ( (i+1) < n && c[i+1] == 0) {
                        emmaPosition = emmaPosition + 2;
                        i = emmaPosition;
                    } else {
                        emmaPosition++ ;
                    }
                    step++;
                } else {
                    emmaPosition = emmaPosition + 2;
                    i = emmaPosition;
                    step++;
                }
            }
        }
        print("step is: " + step);
        return step;
        //self

    }

    static int power(int a, int b) {
       int result = a;
       for (int i = 0; i < b - 1; i++) {
           result *= a;
       }
       return result;
    }

    static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main (String[] ar) {
        jumpingOnClouds(new int[]{
                //0,1,0,0,0,1,0
                 0, 0, 1, 0, 0, 1, 0
                //0, 0, 0, 1, 0, 0
        });

    }
}
