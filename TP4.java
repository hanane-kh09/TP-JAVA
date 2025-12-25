// Lien du fichier Tp4 :
// https://github.com/hanane-kh09/TP-JAVA/tree/main/tp4



/**********************************************Exercice1**********************************************/
/***********************Classe Etudiant***********************/
package com.example.tp;

public class Etudiant {

    private static int compteur = 0;
    private final int id;
    private String nom;
    private String prenom;
    private double[] notes;
    private int nbNotes;

    public Etudiant(String nom, String prenom) {
        this.id = ++compteur;
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new double[5];
        this.nbNotes = 0;
    }

    public void ajouterNote(double note) {
        if (nbNotes == notes.length) {
            double[] tmp = new double[notes.length * 2];
            System.arraycopy(notes, 0, tmp, 0, notes.length);
            notes = tmp;
        }
        notes[nbNotes++] = note;
    }

    public double calculerMoyenne() {
        if (nbNotes == 0) return 0.0;
        double somme = 0.0;
        for (int i = 0; i < nbNotes; i++) {
            somme += notes[i];
        }
        return somme / nbNotes;
    }

    public void afficherNotes() {
        System.out.print("Notes de " + nom + " " + prenom + " : ");
        for (int i = 0; i < nbNotes; i++) {
            System.out.print(notes[i]);
            if (i < nbNotes - 1) System.out.print(", ");
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "Etudiant[id=" + id +
               ", nom=" + nom +
               ", prenom=" + prenom +
               ", moyenne=" + String.format("%.2f", calculerMoyenne()) +
               "]";
    }
}


/***********************Classe Main***********************/


public class Main {
    public static void main(String[] args) {
        Etudiant e1 = new Etudiant("Dupont", "Alice");
        Etudiant e2 = new Etudiant("Martin", "Bob");

        e1.ajouterNote(14.5);
        e1.ajouterNote(12.0);
        e1.ajouterNote(16.0);
        e2.ajouterNote(10.0);
        e2.ajouterNote(13.5);

        e1.afficherNotes();
        System.out.println(e1);

        e2.afficherNotes();
        System.out.println(e2);
    }
}


/**********************************************Exercice2**********************************************/
/***********************Classe Etudiant***********************/
package com.example.tp;

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

/***********************Classe Filiere***********************/

package com.example.tp;

public class Filiere {
    private static int compteur = 0;
    private final int id;
    private String nom;
    private Etudiant[] etudiants;
    private int nbEtudiants;

    public Filiere(String nom) {
        this.id = ++compteur;
        this.nom = nom;
        this.etudiants = new Etudiant[5];
        this.nbEtudiants = 0;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getNbEtudiants() { return nbEtudiants; }

    public void ajouterEtudiant(Etudiant e) {
        if (nbEtudiants == etudiants.length) {
            Etudiant[] tmp = new Etudiant[etudiants.length * 2];
            System.arraycopy(etudiants, 0, tmp, 0, etudiants.length);
            etudiants = tmp;
        }
        etudiants[nbEtudiants++] = e;
        e.setFiliere(this);
    }

    public void afficherEtudiants() {
        System.out.println("Filière " + nom + " (id=" + id + ") → " + nbEtudiants + " étudiants :");
        for (int i = 0; i < nbEtudiants; i++) {
            System.out.println("  • " +
                etudiants[i].getNom() + " " +
                etudiants[i].getPrenom() +
                " (id=" + etudiants[i].getId() + ")"
            );
        }
    }

    @Override
    public String toString() {
        return "Filiere[id=" + id +
               ", nom=" + nom +
               ", nbEtudiants=" + nbEtudiants +
               "]";
    }
}

/***********************Classe Main***********************/

package com.example.tp;

public class Main {
    public static void main(String[] args) {
        Filiere info   = new Filiere("Informatique");
        Filiere genie  = new Filiere("Génie Civil");

        Etudiant e1 = new Etudiant("El Idrissi", "Mohamed");
        Etudiant e2 = new Etudiant("Bentaleb", "Fatima");
        Etudiant e3 = new Etudiant("Chouaib",   "Youssef");
        Etudiant e4 = new Etudiant("Lahlou",    "Salma");
        Etudiant e5 = new Etudiant("Roussafi",  "Hassan");
        Etudiant e6 = new Etudiant("Amrani",    "Aïcha");

        info.ajouterEtudiant(e1);
        info.ajouterEtudiant(e2);
        info.ajouterEtudiant(e3);
        info.ajouterEtudiant(e4);
        info.ajouterEtudiant(e5);
        info.ajouterEtudiant(e6);

        genie.ajouterEtudiant(new Etudiant("Belkahia", "Khadija"));
        genie.ajouterEtudiant(new Etudiant("Laaroussi","Walid"));

        System.out.println(info);
        info.afficherEtudiants();
        System.out.println();

        System.out.println(genie);
        genie.afficherEtudiants();
        System.out.println();

        System.out.println("Détail de e3 : " + e3);
    }
}


/**********************************************Exercice3**********************************************/

/***********************Classe Categorie***********************/
package ma.projet.bean;

public class Categorie {
	public static int compteur = 1;
	private int id; 
	private String libelle;
	private String code;

	public Categorie(String libelle, String code) {
		this.id = compteur++;
		this.libelle = libelle;
		this.code = code;

	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + ", code=" + code + "]";
	}
	
}

/***********************Classe Article***********************/

package ma.projet.bean;

public class Article {

	private static int compteur = 1;
	private int id;
	private int code;
	private String designation;
	private Categorie categorie;
	
	public Article (int code, String designation, Categorie categorie ) {
		
		this.id = compteur++;
		this.code = code;
		this.designation = designation;
		this.categorie = categorie;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return id + " " + code + " " + designation;
	}
	
}


/***********************Classe TestApp***********************/

package ma.projet.test;
import ma.projet.bean.Categorie;
import ma.projet.bean.Article;

public class TestApp {

	public static void main(String[] args) {
		
		Categorie c1 = new Categorie("Ordinateur Portable", "O PR");
		Categorie c2 = new Categorie("Ordinateur Poste", "O PO");
		
		Categorie [] categorie = new Categorie[2];
		categorie[0] = c1;
		categorie[1] = c2;
		
		Article a1 = new Article (14, "DELL INSPIRON", c1);
		Article a2 = new Article (4, "SONY VAIO", c1);
		Article a3 = new Article (74, "TERRA", c2);
		Article a4 = new Article (785, "HP Compaq", c2);
		
		Article[] article= new Article[4];
		article[0]= a1;
		article[1]= a2;
		article[2]= a3;
		article[3]= a4;
		
		for (Categorie cat : categorie) {
            System.out.println(cat.getLibelle() + " :");

            for (Article art : article) {
                if (art.getCategorie().getId() == cat.getId()) {
                    System.out.println("  - " + art.toString());
                }
            }
            System.out.println();
        }
	}
}



/**********************************************Exercice4**********************************************/

/***********************Classe Livre***********************/
package com.example.tp;

public class Livre {
    private static int compteur = 0;
    private final int id;
    private String titre;
    private Auteur auteur;

    public Livre(String titre, Auteur auteur) {
        this.id = ++compteur;
        this.titre = titre;
        this.auteur = auteur;
        auteur.ajouterLivre(this); 
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public Auteur getAuteur() { return auteur; }

    @Override
    public String toString() {
        return "Livre[id=" + id +
               ", titre=" + titre +
               ", auteur=" + auteur.getNom() +
               "]";
    }
}
/***********************Classe Auteur***********************/
package com.example.tp;

import java.util.ArrayList;
import java.util.List;

public class Auteur {
    private static int compteur = 0; 
    private final int id;
    private String nom;
    private List<Livre> livres = new ArrayList<>();

    public Auteur(String nom) {
        this.id = ++compteur; 
        this.nom = nom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public List<Livre> getLivres() { return livres; }

    public void ajouterLivre(Livre livre) {
        if (!livres.contains(livre)) {
            livres.add(livre);
        }
    }

    @Override
    public String toString() {
        return "Auteur[id=" + id +
               ", nom=" + nom +
               ", nbLivres=" + livres.size() +
               "]";
    }
}

/***********************Classe Bibliotheque***********************/
package com.example.tp;

import java.util.HashSet;
import java.util.Set;

public class Bibliotheque {
    private static int compteur = 0;
    private final int id;
    private String nom;
    private Set<Livre> collection = new HashSet<>();

    public Bibliotheque(String nom) {
        this.id = ++compteur;
        this.nom = nom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public Set<Livre> getCollection() { return collection; }

    public void ajouterLivre(Livre livre) {
        collection.add(livre);
    }

    @Override
    public String toString() {
        return "Bibliotheque[id=" + id +
               ", nom=" + nom +
               ", taille=" + collection.size() +
               "]";
    }
}

/***********************Classe Main***********************/
package com.example.tp;

public class Main {
    public static void main(String[] args) {
        // Création d’auteurs
        Auteur hugo   = new Auteur("Victor Hugo");
        Auteur orwell = new Auteur("George Orwell");

        // Création de livres (liaison avec auteur automatique)
        Livre m1    = new Livre("Les Misérables", hugo);
        Livre ndp   = new Livre("Notre-Dame de Paris", hugo);
        Livre l1984 = new Livre("1984", orwell);

        // Création de bibliothèques
        Bibliotheque centrale = new Bibliotheque("Centrale");
        Bibliotheque quartier = new Bibliotheque("Quartier");

        // Associations bibliothèque ↔ livres
        centrale.ajouterLivre(m1);
        centrale.ajouterLivre(l1984);
        quartier.ajouterLivre(m1);
        quartier.ajouterLivre(ndp);

        // Affichage auteurs et leurs livres
        System.out.println(hugo);
        hugo.getLivres().forEach(l ->
            System.out.println("  • " + l)
        );

        System.out.println(orwell);
        orwell.getLivres().forEach(l ->
            System.out.println("  • " + l)
        );

        // Affichage bibliothèques et leur collection
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




