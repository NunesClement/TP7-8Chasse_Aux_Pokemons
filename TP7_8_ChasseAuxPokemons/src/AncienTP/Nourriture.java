package AncienTP;

public class Nourriture {
	private int apport;
	private String ingredient;
	private String[] compatibilites;
	public int frequence;

	// TP 4 : constructeur modifie
	public Nourriture(int apport, String ingredient, String[] compatibilites, int frequence) {
		this.apport = apport;
		this.ingredient = ingredient;
		this.compatibilites = compatibilites;
		this.frequence = frequence;
	}

	
	public String getIngredient() {
		return this.ingredient;
	}

	// TP 4
	public String[] getCompatibilites () {
		return this.compatibilites;
	}
	
	// TP 4
	public int getApport() {
		return this.apport;
	}
	
	// TP 4
	public int getFrequence() {
		return this.frequence;
	}
	
	public boolean estCompatible(String type) {
		for (int i = 0; i < this.compatibilites.length; i++) {
			if (type.equals(this.compatibilites[i]))
				return true;
		}

		return false;
	}

	public boolean seraGenere() {
		return (Math.round(100 * Math.random()) < this.frequence);
	}
	
	// Modifie en TP 4
	public Nourriture genAlea() {
		if (this.seraGenere())
			return new Nourriture(this.apport, this.ingredient, this.compatibilites,this.frequence);
		
		return null;
	}
	
	// TP 4
	
	public void estMangee(Pokemon mangeur) {
		if (this.estCompatible(mangeur.getType())) {
			mangeur.baisseAppetit(this.apport);
		}
		else {
			System.out.println("Votre pokemon ne pourra pas manger cette nourriture, qui n'est pas compatible avec son type.");
		}
	}



	public String toString() {
		String compatibilites = this.compatibilites[0];
		for (int i = 1; i < this.compatibilites.length; ++i) {
			compatibilites = compatibilites + ", " + this.compatibilites[i];
		}

		return ("nourriture " + this.ingredient
			+ ", soulage l'appetit par " + this.apport
			+ " et peut etre mangee par les types prochains de pokemons : " + compatibilites
			+ ". Elle apparait avec un frequence " + this.frequence);
	}

	

}
