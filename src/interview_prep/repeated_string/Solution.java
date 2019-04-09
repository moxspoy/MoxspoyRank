package interview_prep.repeated_string;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        //input abcac, 10
        //output 4
        print(n);
        long limit = power(10, 13);
        long numOfOccurences = 0;
        int strLength = s.length();
        long strSize = (long) strLength;
        if (strLength >= 1 && strLength <= 100) {
            if (n >= 1 && n <= limit) {

                //find first how many a in first given string
                int initialSizeOfString = s.length() - s.replace("a", "").length();

                print("init: " + initialSizeOfString);

                long times = n/strSize;

                long numberOfLoop = 0;

                //using mod
                long modResult = n % strLength;
                numberOfLoop =  times * initialSizeOfString;

                print("times: " + times + ",modresult: " + modResult);

                if (modResult != 0) {
                    long sizeOfStringIfModResultAvailable = 0;
                    for (int i = 0; i < modResult; i++) {
                        if(s.charAt(i) == 'a')
                        {
                            numberOfLoop++;
                        }
                    }
                    print("size of string: " + sizeOfStringIfModResultAvailable
                            + "updated numberof loop: " + numberOfLoop);
                }

                numOfOccurences = numberOfLoop;
            }
        }
        return numOfOccurences;
        //self

    }

    static long power(int a, int b) {
       long result = a;
       for (int i = 0; i < b - 1; i++) {
           result *= a;
       }
       return result;
    }

    static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main (String[] ar) {
        long num = repeatedString(
                "gfcaaaecbg",
                547602
        );
//        //long num = 1000000000000;
//        long num = Long.MAX_VALUE;
        print(num);
    }
}
