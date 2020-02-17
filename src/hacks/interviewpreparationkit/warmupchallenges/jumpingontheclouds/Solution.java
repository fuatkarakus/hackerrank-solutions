package hacks.interviewpreparationkit.warmupchallenges.jumpingontheclouds;
import java.io.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;
        int size = c.length;
        while ( i < size ) {
                if ( i + 2 < size && c[i + 2] == 0 ) {
                    i = i + 2;
                    jumps++;
                    continue;
                } else {
                    i = i + 1;
                    jumps ++;
                    continue;
                }
            }
            return jumps;
        }

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,1,0};
        System.out.println(jumpingOnClouds(arr));
    }
}
