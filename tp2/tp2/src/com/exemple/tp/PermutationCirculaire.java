package com.exemple.tp;

public class PermutationCirculaire {

    public static boolean estPermutationCirculaire(int[] t) {
        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        for (int x : t) {
            if (x < 1 || x > n) return false;
            if (vu[x]) return false;
            vu[x] = true;
        }

        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                pos = i;
                break;
            }
        }
        if (pos == -1) return false;

        for (int k = 0; k < n; k++) {
            int idx = (pos + k) % n;
            if (t[idx] != k + 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a = {4,5,1,2,3};
        int[] b = {3,1,2,4,5};
        int[] c = {2,3,4,5,1};
        int[] d = {1,2,2,3,4};

        System.out.println(estPermutationCirculaire(a)); 
        System.out.println(estPermutationCirculaire(b));
        System.out.println(estPermutationCirculaire(c));
        System.out.println(estPermutationCirculaire(d));
    }
}
