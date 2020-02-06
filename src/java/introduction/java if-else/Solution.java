import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static String printInt(int n) {
        if ((n & 1) == 1 | (((n & 1) == 0) & (20>=n & n>=6))) {
            return "Weird";
        } else if (((n & 1) == 0) & ((2<=n & n<=5) | ( n > 20 ))) {
            return "Not Weird";
        } else
            return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(printInt(N));
        scanner.close();
    }
}