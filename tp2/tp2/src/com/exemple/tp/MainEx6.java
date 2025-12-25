package com.exemple.tp;

public class MainEx6 {


    public static int maxSubarraySum(int[] t) {
        if (t == null || t.length == 0) return 0;

        int currentSum = t[0];
        int maxSum = t[0];

        for (int i = 1; i < t.length; i++) {
            currentSum = Math.max(t[i], currentSum + t[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public static int[] kadaneWithIndices(int[] t) {
        if (t == null || t.length == 0) return new int[]{0, -1, -1};

        int currentSum = t[0];
        int maxSum = t[0];

        int start = 0;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < t.length; i++) {

            if (t[i] > currentSum + t[i]) {
                currentSum = t[i];
                start = i;
            } else {
                currentSum += t[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
                bestEnd = i;
            }
        }

        return new int[]{maxSum, bestStart, bestEnd};
    }


    public static void main(String[] args) {

        int[] t = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int somme = maxSubarraySum(t);
        System.out.println("Somme maximale = " + somme);

        int[] res = kadaneWithIndices(t);
        System.out.println("Somme = " + res[0]);
        System.out.println("Début = " + res[1]);
        System.out.println("Fin   = " + res[2]);

        System.out.print("Sous-suite : ");
        for (int i = res[1]; i <= res[2]; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }
}
