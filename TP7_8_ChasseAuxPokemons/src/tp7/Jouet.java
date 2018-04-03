package tp7;

public class Jouet extends Item implements Utilisable, Modifiable{
	private int apportAppetit;
	private int apportSatisfaction;
	private int apportLoyaute;
	
	public Jouet(String nom, int frequence, int apportAppetit, int apportSatisfaction, int apportLoyaute) {
		super(nom, frequence);
		this.apportAppetit = apportAppetit;
		this.apportSatisfaction = apportSatisfaction;
		this.apportLoyaute = apportLoyaute;
	}
}
