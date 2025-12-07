package ma.projet.test;

import ma.projet.test.Tableaux;

public class MainEx4 {
    public static void main(String[] args) {

        double[][] t1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        double[][] t2 = {
            {10, 10, 10},
            {20, 20, 20}
        };

        System.out.println("Affichage t1 :");
        Tableaux.affiche(t1);

        System.out.println("Tableau régulier ? " + Tableaux.regulier(t1));

        System.out.println("Sommes des lignes :");
        double[] sl = Tableaux.sommeLignes(t1);
        for (double x : sl) System.out.println(x);

        System.out.println("Somme t1 + t2 :");
        Tableaux.affiche(Tableaux.somme(t1, t2));
    }
}