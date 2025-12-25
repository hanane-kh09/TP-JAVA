package com.exemple.tp;

import java.util.HashMap;

public class MainEx7 {

    public static int elementMajoritaire(int[] t) {
        if (t == null || t.length == 0) return -1;

        int candidat = trouverCandidat(t);

        if (estMajoritaire(t, candidat)) {
            return candidat;
        }
        return -1;
    }

    public static int elementMajoritaireNaif(int[] t) {
        if (t == null || t.length == 0) return -1;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int x : t) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int n = t.length;
        for (int x : freq.keySet()) {
            if (freq.get(x) > n / 2) {
                return x;
            }
        }

        return -1;
    }

    private static int trouverCandidat(int[] t) {
        int candidat = t[0];
        int compteur = 1;

        for (int i = 1; i < t.length; i++) {
            if (t[i] == candidat) {
                compteur++;
            } else {
                compteur--;
                if (compteur == 0) {
                    candidat = t[i];
                    compteur = 1;
                }
            }
        }
        return candidat;
    }

    private static boolean estMajoritaire(int[] t, int c) {
        int count = 0;
        for (int x : t) {
            if (x == c) count++;
        }
        return count > t.length / 2;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {3, 3, 4, 3, 5},
            {2, 2, 1, 2, 3, 2, 2},
            {1, 2, 3, 4},
            {1, 1, 2, 2},
            {-1, -1, -1, 2, 3},
            {-2, -2, -2, -2, 1, 3},
            {},
            {10}
        };

        for (int[] t : tests) {
            System.out.print("Tableau : ");
            for (int x : t) System.out.print(x + " ");

            int res = elementMajoritaire(t);
            System.out.println("\nÉlément majoritaire = " + res);

        }
    }
}
