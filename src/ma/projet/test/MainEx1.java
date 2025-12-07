package ma.projet.test;

import java.util.Scanner;

public class MainEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez la valeur de n : ");
        int n = sc.nextInt();

        double somme = 0.0;

        for (int i = 1; i <= n; i++) {
            somme += 1.0 / i;
        }

        System.out.println("La somme harmonique H(" + n + ") = " + somme);
    }
}