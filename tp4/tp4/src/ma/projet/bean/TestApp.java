package ma.projet.bean;

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