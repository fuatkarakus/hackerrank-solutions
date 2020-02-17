package hacks.interviewpreparationkit.repeatedstring;
import com.sun.javaws.progress.PreloaderPostEventListener;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if ( s.equals("a") ) {
            return n;
        }
        if ( !s.contains("a") ) {
            return 0;
        }
        int stringSize = s.length();
        if (n <  stringSize) {
            return s.substring(0, (int)n).chars().filter(ch -> ch == 'a').count();
        }else {
            boolean isFactor = n % stringSize == 0;
            long a = n % stringSize;
            long repeat =  n/stringSize;
            long count =  s.chars().filter(ch -> ch == 'a').count();
            count = count * repeat;
            long subCount = 0 ;
            if (!isFactor) {
                String sub = s.substring(0, (int)a);
                subCount = sub.chars().filter(ch -> ch == 'a').count();
            }
            return subCount + count;
        }
    }

    public static void main(String[] args) throws IOException {
        String string = "cfimaakj";
        long n = 554045874191L;
        System.out.println(string.chars().filter(ch -> ch == 'a').count());
        System.out.println(repeatedString(string, n));
    }
}
