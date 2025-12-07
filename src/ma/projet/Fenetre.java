package ma.projet;

import java.util.Scanner;

public class Fenetre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       // taille du tableau
        int k = sc.nextInt();       // taille de la fenêtre

        int[] T = new int[n];
        for (int i = 0; i < n; i++) {
            T[i] = sc.nextInt();
        }

        int MAXV = 100000;          // valeur max possible
        int[] freq = new int[MAXV + 1]; // tableau de fréquence
        int distinct = 0;           // nombre d'éléments distincts

        // --- Initialiser la première fenêtre [0..k-1]
        for (int i = 0; i < k; i++) {
            if (freq[T[i]] == 0) distinct++; // nouveau distinct
            freq[T[i]]++;
        }

        // --- Affichage du premier résultat
        System.out.print(distinct);

        // --- Glissement de la fenêtre
        for (int i = k; i < n; i++) {
            int out = T[i - k]; // élément sortant
            freq[out]--;
            if (freq[out] == 0) distinct--; // plus présent dans la fenêtre

            int in = T[i]; // élément entrant
            if (freq[in] == 0) distinct++; // nouvel élément distinct
            freq[in]++;

            System.out.print(" " + distinct);
        }

        System.out.println(); // saut de ligne final
        sc.close();
    }
}
