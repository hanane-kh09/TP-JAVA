package com.exemple.tp;

public class MainEx10 {

    public static boolean estCarreMagique(int[][] m) {
        int ref = m[0][0] + m[0][1] + m[0][2];

        if (m[1][0] + m[1][1] + m[1][2] != ref) return false;
        if (m[2][0] + m[2][1] + m[2][2] != ref) return false;

        if (m[0][0] + m[1][0] + m[2][0] != ref) return false;
        if (m[0][1] + m[1][1] + m[2][1] != ref) return false;
        if (m[0][2] + m[1][2] + m[2][2] != ref) return false;

        if (m[0][0] + m[1][1] + m[2][2] != ref) return false;
        if (m[0][2] + m[1][1] + m[2][0] != ref) return false;

        return true;
    }

    public static void main(String[] args) {

        int[][] m1 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };

        int[][] m2 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 7}
        };

        if (estCarreMagique(m1)) System.out.println("Carré magique");
        else System.out.println("Pas un carré magique");

        if (estCarreMagique(m2)) System.out.println("Carré magique");
        else System.out.println("Pas un carré magique");
    }
}
