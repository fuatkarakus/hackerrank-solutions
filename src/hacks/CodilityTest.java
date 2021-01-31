package hacks;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


class Calculator {
    int add(int a, int b){
        return a+ b;
    }
}

class Adder extends Calculator {

    public void  za() {
        short a = 6;
        System.out.println(add(a, 6));
    }
}

class Comparator {

    public boolean compare(int a, int b){
        return a == b;
    }

    public boolean compare(String a, String b){
        return a.equals(b);
    }
    public boolean compare(int[] a, int[] b){
        boolean flag = false;
        if (a.length == b.length) {
            int x = 0;
            for (int i = 0; i < a.length; i ++ ) {
                if (compare(a[i], b[i])) {
                    x ++;
                }
            }
            if (x == a.length) flag= true;
        }
        return flag;
    }
}

public class CodilityTest {

    static void staircase(int n) {

        for (int i = 0; i < n; i++) { //0
            for (int j = 0; j < n; j++) { //0 1 2 3 4 5

                if (n - 1 <= i + j) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    static void plusMinus(int[] arr) {
        int size = arr.length;
        int pos = 0;
        int neg = 0;
        int zer = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                zer += 1;
            }
            if (arr[i] > 0) {
                pos += 1;
            }
            if (arr[i] < 0) {
                neg += 1;
            }
        }
        System.out.println(Math.floorDiv(pos, size));
        System.out.println(Math.floorDiv(neg, size));
        System.out.println(Math.floorDiv(zer, size));

    }

    static List<Integer> compareTriplets(List<List<Integer>> arr) {
        int principal = 0, secondary = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(0).size(); j++) {

                // Condition for principal
                // diagonal
                if (i == j)
                    principal += arr.get(i).get(j);

                // Condition for secondary
                // diagonal
                if ((i + j) == (arr.size() - 1))
                    secondary += arr.get(i).get(j);
            }
        }

        int i = Math.abs(principal - secondary);
        return null;
    }

    // Complete the minimumBribes function below.
    static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) continue;
            count++;
            int tmp = arr[i];
            arr[i] = arr[tmp - 1];
            arr[tmp - 1] = tmp;
            i--;
        }
        return count;
    }

    static long arrayManipulation(int n, int[][] queries) {
        int[] zero = new int[n];
        long max = Long.MIN_VALUE;
        int start, end, add;
        for (int i = 0; i < queries.length; i++) {
            start = queries[i][0] - 1;
            end = queries[i][1] - 1;
            add = queries[i][2];

            zero[start] += add;
            zero[end] -= add;
        }

        for (int i = 1; i < zero.length; i++) {
            zero[i] += zero[i - 1];
            if (zero[i] > max) {
                max = zero[i];
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}};

        staircase(6);

        new Adder().za();

    }
}
