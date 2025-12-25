package com.example.tp4;

public class MainEx4 {
    public static void main(String[] args) {

        Auteur hugo   = new Auteur("Victor Hugo");
        Auteur orwell = new Auteur("George Orwell");

        Livre m1    = new Livre("Les Misérables", hugo);
        Livre ndp   = new Livre("Notre-Dame de Paris", hugo);
        Livre l1984 = new Livre("1984", orwell);

        Bibliotheque centrale = new Bibliotheque("Centrale");
        Bibliotheque quartier = new Bibliotheque("Quartier");

        centrale.ajouterLivre(m1);
        centrale.ajouterLivre(l1984);
        quartier.ajouterLivre(m1);
        quartier.ajouterLivre(ndp);

        System.out.println(hugo);
        hugo.getLivres().forEach(l ->
            System.out.println("  • " + l)
        );

        System.out.println(orwell);
        orwell.getLivres().forEach(l ->
            System.out.println("  • " + l)
        );

        System.out.println(centrale);
        centrale.getCollection().forEach(l ->
            System.out.println("  – " + l.getTitre() + " (id=" + l.getId() + ")")
        );

        System.out.println(quartier);
        quartier.getCollection().forEach(l ->
            System.out.println("  – " + l.getTitre() + " (id=" + l.getId() + ")")
        );
    }
}
