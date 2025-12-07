package ma.projet.test;

import java.util.Scanner;

public class MainEx2 {
    public static void main(String args[]) {
 
        Scanner input = new Scanner(System.in);
        System.out.print("Tapez un numero: ");
        int n = input.nextInt();
 
        for(int i = 1; i <= n; i++) {
 
            for(int s = 1; s <= n - i; s++){
                System.out.print(" ");
            }
 
            for(int e = 1; e <= 2*i - 1; e++){
                System.out.print("*");
            }
 
            System.out.println();
        }
    }
}