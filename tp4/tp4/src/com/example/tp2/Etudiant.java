package com.example.tp2;
import com.example.tp2.Filiere;

public class Etudiant {
    private static int compteur = 0;
    private final int id;
    private String nom;
    private String prenom;
    private Filiere filiere;

    public Etudiant(String nom, String prenom) {
        this.id = ++compteur;
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setFiliere(Filiere f) {
        this.filiere = f;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public Filiere getFiliere() { return filiere; }

    @Override
    public String toString() {
        String fil = (filiere != null) ? filiere.getNom() : "Aucune";
        return "Étudiant[id=" + id +
               ", nom=" + nom +
               ", prénom=" + prenom +
               ", filière=" + fil +
               "]";
    }
}