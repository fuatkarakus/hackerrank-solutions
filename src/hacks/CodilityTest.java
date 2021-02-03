package hacks;


import java.util.*;


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


    public static int longestSubarray(List<Integer> arr) {
        if(arr.size() < 2) {
            return arr.size();
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 1;
        while (i < arr.size() - 1) {
            set.add(arr.get(i));
            while (j < arr.size() && Math.abs(arr.get(i) - arr.get(j)) < 2) {
                if (!set.contains(arr.get(j))) {
                    if (set.size() == 2) {
                        break;
                    } else {
                        set.add(arr.get(j));
                    }
                }
                ++j;
            }
            max = Math.max(max, j - i);
            j = ++i + 1;
            set.clear();
        }
        return max;
    }

    public static String findSubstring(String s, int k) {
        List<String> vovels = Arrays.asList("a", "e", "i", "o", "u");
        int size=  s.length();
        String sub = "";
        for ( int i = 0; i < size ; i ++ ) {
            if (i + k > size) {
                break;
            }
            sub = s.substring(i, i + k);
            int count = (int ) Arrays.stream(sub.split("")).filter(vovels::contains).count();
            if (count == k) {
                break;
            } else {
                sub = "Not Found!";
            }
        }
        return sub;
    }

    static int dp[][] = new int[1001][1001];

    public static int isPal(String s, int i, int j) {

        if (i > j)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) != s.charAt(j))
            return dp[i][j] = 0;

        return dp[i][j] = isPal(s, i + 1, j - 1);
    }

    public static int countSubstrings(String s) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPal(s, i, j) != 0)
                    count++;
            }
        }
        int c = s.length();
        return count + c ;
    }

    public static int jumps(int flagHeight, int bigJump) {
        return  ((flagHeight -  (flagHeight % bigJump) ) / bigJump) +  (flagHeight % bigJump) ;
    }

    public static int countPairs(List<Integer> numbers, int k) {
        HashSet<Integer> hLow = new HashSet<>();
        HashSet<Integer> hHigh = new HashSet<>();
        int count = 0;
        for (int i : numbers) {
            hLow.add(i);
            hHigh.add(i+k);
        }
        for (int i : hHigh) {
            if (hLow.contains(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}};

        //System.out.println(longestSubarray(Arrays.asList(195593459,195593459,195593458,195593457,195593459,195593459,195593458,195593459,195593458,195593459,195593457,195593458,195593458,195593457,195593457,195593457,195593457,195593458,195593457,195593459,195593457,195593457,195593458,195593457,195593457,195593458,195593458,195593457,195593458,195593457,195593457,195593457,195593459,195593459,195593459,195593458,195593458,195593458,195593458,195593458,195593457,195593459,195593459,195593458,195593457,195593459,195593459,195593457,195593459,195593459,195593457,195593457,195593459,195593459,195593457,195593459,195593458,195593458,195593458,195593457,195593458,195593458,195593458,195593458,195593457,195593458,195593459,195593458,195593459,195593458,195593459,195593458,195593458,195593459,195593459,195593458,195593457,195593459,195593459,195593459,195593459,195593457,195593459,195593459,195593459,195593459,195593459,195593457,195593459,195593457,195593458,195593457,195593458,195593458,195593457,195593459,195593457,195593457,195593459,195593457,195593459,195593459,195593458,195593457,195593459,195593458,195593459,195593459,195593458,195593458,195593459,195593458,195593459,195593458,195593457,195593459,195593458,195593457,195593457,195593457,195593458,195593457,195593459,195593457,195593458,195593459,195593458,195593458,195593459,195593457,195593459,195593459,195593459,195593458,195593459,195593458,195593458,195593459,195593458,195593459,195593458,195593457,195593457,195593457,195593459,195593458,195593459,195593458,195593457)));
        // System.out.println(longestSubarray(Arrays.asList(1,1, 1, 2, 2, 3)));

        System.out.println(countPairs(Arrays.asList( 1, 1, 2, 2, 3, 3), 1));
    }
}
