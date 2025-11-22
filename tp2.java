import java.util.*;

public class Main {

   
    // EXERCICE 1 : 
    public static int lisLength(int[] t) {
        int n = t.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (t[j] < t[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int x : dp) if (x > max) max = x;
        return max;
    }


    // EXERCICE 2 : 

    public static List<Integer> pivots(int[] t) {
        int n = t.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean ok = true;

            for (int j = 0; j < i; j++)
                if (t[j] > t[i]) ok = false;

            for (int j = i + 1; j < n; j++)
                if (t[j] < t[i]) ok = false;

            if (ok) res.add(t[i]);
        }
        return res;
    }



    // EXERCICE 3 : 

    public static int[][] spiral(int n) {
        int[][] m = new int[n][n];
        int num = 1;

        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++) m[top][j] = num++;
            top++;

            for (int i = top; i <= bottom; i++) m[i][right] = num++;
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) m[bottom][j] = num++;
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) m[i][left] = num++;
                left++;
            }
        }

        return m;
    }



    // EXERCICE 4 : 

    public static int maxRectangle(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int maxArea = 0;

        for (int top = 0; top < rows; top++) {
            for (int left = 0; left < cols; left++) {

                if (m[top][left] == 0) continue;

                for (int bottom = top; bottom < rows; bottom++) {
                    for (int right = left; right < cols; right++) {

                        boolean fullOnes = true;

                        for (int i = top; i <= bottom; i++) {
                            for (int j = left; j <= right; j++) {
                                if (m[i][j] == 0) fullOnes = false;
                            }
                        }

                        if (fullOnes) {
                            int area = (bottom - top + 1) * (right - left + 1);
                            if (area > maxArea) maxArea = area;
                        }
                    }
                }
            }
        }

        return maxArea;
    }



    // EXERCICE 5 : 

    public static boolean isCircular(int[] t) {
        int n = t.length;

        for (int k = 1; k <= n; k++) {
            boolean found = false;
            for (int x : t) if (x == k) found = true;
            if (!found) return false;
        }

        int start = -1;
        for (int i = 0; i < n; i++) if (t[i] == 1) start = i;


        for (int i = 0; i < n; i++) {
            if (t[(start + i) % n] != i + 1) return false;
        }

        return true;
    }



    // EXERCICE 6 : 
    public static int maxSubArray(int[] t) {
        int max = t[0];
        int current = t[0];

        for (int i = 1; i < t.length; i++) {
            current = Math.max(t[i], current + t[i]);
            max = Math.max(max, current);
        }

        return max;
    }



    // EXERCICE 7 : 
    public static int majority(int[] t) {
        int n = t.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++)
                if (t[j] == t[i]) count++;

            if (count > n / 2) return t[i];
        }
        return -1;
    }



    // EXERCICE 8 : 

    public static List<Integer> missing(int[] t) {
        int n = t.length;
        List<Integer> res = new ArrayList<>();

        for (int k = 1; k <= n; k++) {
            boolean found = false;
            for (int x : t) if (x == k) found = true;
            if (!found) res.add(k);
        }

        return res;
    }



    // EXERCICE 9 : 

    public static int diagonalDiff(int[][] m) {
        int n = m.length;
        int d1 = 0, d2 = 0;

        for (int i = 0; i < n; i++) {
            d1 += m[i][i];
            d2 += m[i][n - 1 - i];
        }

        return Math.abs(d1 - d2);
    }



    // EXERCICE 10 : Carré magique 3×3

    public static boolean isMagic(int[][] m) {
        int target = m[0][0] + m[0][1] + m[0][2];

        for (int i = 0; i < 3; i++) {
            int row = 0;
            for (int j = 0; j < 3; j++) row += m[i][j];
            if (row != target) return false;
        }

        for (int j = 0; j < 3; j++) {
            int col = 0;
            for (int i = 0; i < 3; i++) col += m[i][j];
            if (col != target) return false;
        }

        int d1 = m[0][0] + m[1][1] + m[2][2];
        int d2 = m[0][2] + m[1][1] + m[2][0];

        return d1 == target && d2 == target;
    }



    // MAIN :

    public static void main(String[] args) {


        System.out.println("LIS = " + lisLength(new int[]{2,1,4,2,3,5,1,7}));
        System.out.println("Pivots = " + pivots(new int[]{2,4,3,5,6}));
        System.out.println("Permutation circulaire = " + isCircular(new int[]{4,5,1,2,3}));  
        System.out.println("Kadane = " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}
