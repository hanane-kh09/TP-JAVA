package com.exemple.tp;

public class MainEx8 {

    public static void afficherElementsManquants(int[] t) {
        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        boolean aucun = true;
        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                System.out.print(k + " ");
                aucun = false;
            }
        }

        if (aucun) {
            System.out.print("Aucun élément manquant");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[][] tests = {
            {1, 3, 3, 5},    // n=4 normalement mais exemple n=5
            {1, 2, 3, 4},
            {3, 3, 3},
            {1, 1, 1, 1},
            {4, 2, 2, 1, 5},
            {1},
            {1, 2, 3, 6}
        };

        int[] nValues = {5, 4, 3, 4, 5, 1, 4};

        for (int i = 0; i < tests.length; i++) {
            int[] t = tests[i];
            int n = nValues[i];

            System.out.print("Tableau : ");
            for (int x : t) System.out.print(x + " ");

            System.out.print("\nManquants : ");
            afficherElementsManquants(adjustArraySize(t, n));


        }
    }

    private static int[] adjustArraySize(int[] t, int n) {
        int[] newT = new int[n];
        for (int i = 0; i < n && i < t.length; i++) {
            newT[i] = t[i];
        }
        return newT;
    }
}
