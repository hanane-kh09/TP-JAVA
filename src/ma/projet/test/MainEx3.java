package ma.projet.test;

import java.util.Scanner;
 
public class MainEx3 {
    public static void main(String args[]) {
 
        Scanner input = new Scanner(System.in);
        System.out.print("Tapez un numero: ");
        int n = input.nextInt();
 
        int impaire = 1;
 
        for(int i = 1; i <= n; i++) {
 
            int carre = impaire * impaire;
 
            System.out.println(impaire + " a pour carre " + carre);
 
            impaire += 2;
        }
    }
}