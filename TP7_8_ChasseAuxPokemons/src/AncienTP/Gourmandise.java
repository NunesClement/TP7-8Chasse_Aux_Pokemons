package AncienTP;

public class Gourmandise extends Nourriture {

	private int apportSatisfaction;
	private int apportLoyaute;
	
	public Gourmandise(int apport, String ingredient, String[] compatibilites, int frequence, int apportSatisfaction, int apportLoyaute) {
		super(apport, ingredient, compatibilites, frequence);
		this.apportSatisfaction = apportSatisfaction;
		this.apportLoyaute = apportLoyaute;
	}

	@Override
	public void estMangee(Pokemon mangeur) {
		super.estMangee(mangeur);
		mangeur.monteSatisfaction(this.apportSatisfaction);
		mangeur.monteLoyaute(this.apportLoyaute);
	}

	
	// TP 4
	
	@Override
	public Gourmandise genAlea() {
		if (this.seraGenere()){
			return new Gourmandise(this.getApport(), this.getIngredient(), this.getCompatibilites(), this.getFrequence(), this.apportSatisfaction, this.apportLoyaute);
		}
		return null;
	}

	
	@Override
	public String toString() {
		String compatibilites = this.getCompatibilites()[0];
		for (int i = 1; i < this.getCompatibilites().length; ++i) {
			compatibilites = compatibilites + ", " + this.getCompatibilites()[i];
		}

		return ("Nourriture " + this.getIngredient()
			+ ", soulage l'appetit par " + this.getApport() + ", augmente la satisfaction par " + this.apportSatisfaction 
			+ " et la loyaute par " + this.apportLoyaute 
			+ " et peut etre mangee par les types prochains de pokemons : " + compatibilites
			+ ". Elle apparait avec un frequence " + this.getFrequence());
		
	}	


}
