package interview_prep.sock_merchant;

import java.util.HashMap;

public class Solution {

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int numPair = 0;
        for(int i = 0; i<ar.length; i++) {
            int sock = ar[i];
            if(map.containsKey(sock) && map.get(sock).equals(1)) {
                map.put(sock, 0);
                numPair++;
                continue;
            }
            map.put(sock,1);
        }
        return numPair;
    }

    public static void main (String[] ar) {

    }
}
