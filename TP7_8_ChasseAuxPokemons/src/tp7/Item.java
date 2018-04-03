package tp7;

public abstract class Item {
	private String nom;
	private int frequence,utilisations,utilisationRestantes;
	public Item(String nom, int frequence, int utilisations) {
		super();
		this.nom = nom;
		this.frequence = frequence;
		this.utilisations = utilisations;
		this.utilisationRestantes = utilisations;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getFrequence() {
		return frequence;
	}

	public int getUtilisations() {
		return utilisations;
	}

	public int getUtilisationRestantes() {
		return utilisationRestantes;
	}
	
	public void baisseUtilisations(int difference){
		utilisationRestantes = utilisationRestantes - difference; 
	}
	
	public void monterUtilisation(int difference){
		if ((utilisationRestantes=+difference)<=utilisations)
			utilisationRestantes=+difference;
		else 
			utilisationRestantes=utilisations;
	}
	
	public void resetUtilisation(){
		utilisationRestantes=utilisations;
	}
	public boolean seraGenere(){
		boolean reponse =false;
		int ale=(int) (100*Math.random());
		if(ale<frequence)
			reponse=true;
		return reponse;
	}
	public String toString(){
		return(nom+":"+frequence+","+utilisationRestantes+utilisations);
	}
	
	public abstract Item genAlea();
		
	
}