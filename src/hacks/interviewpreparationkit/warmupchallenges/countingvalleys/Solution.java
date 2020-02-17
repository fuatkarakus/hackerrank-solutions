package hacks.interviewpreparationkit.warmupchallenges.countingvalleys;
import java.io.*;
import java.util.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String str) {
        int level = 0;
        int numValleys = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'U') {
                level++;
                if (level == 0) {
                    numValleys++; // since we just stepped up to sea level
                }
            } else if (ch == 'D') {
                level--;
            }
        }
        return numValleys;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
