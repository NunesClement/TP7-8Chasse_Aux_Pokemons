package tp7;

import AncienTP.Joueur;

public class Jouet extends Item implements Utilisable, Modifiable{
	private int apportAppetit;
	private int apportSatisfaction;
	private int apportLoyaute;
	
	public Jouet(int apportAppetit, int apportSatisfaction, int apportLoyaute) {
		super(getNom(), getFrequence());
		this.apportAppetit = apportAppetit;
		this.apportSatisfaction = apportSatisfaction;
		this.apportLoyaute = apportLoyaute;
	}

	@Override
	public void modifier() {
		
	}

	@Override
	public void utiliser(Joueur j, int indexPokemon) {
		
	}

	@Override
	public Item genAlea() {
		return null;
	}
	
	@Override
	public String toString() {
		return null;
		
	}
}
