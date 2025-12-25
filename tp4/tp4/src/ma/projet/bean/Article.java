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
