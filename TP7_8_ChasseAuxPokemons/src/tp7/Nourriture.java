package tp7;
import AncienTP.Joueur;
import tp7.Item;
import tp7.Utilisable;

public class Nourriture extends Item implements Utilisable{
	private int apport;
	private String[] compatibilites;
	public Nourriture(String nom, int frequence, int utilisations,int apport ,String[] compatibilites) {
		super(nom, frequence, utilisations);
		this.apport=apport;
		this.compatibilites=compatibilites;
	}

	public int getApport() {
		return apport;
	}

	public String[] getCompatibilites() {
		return compatibilites;
	}

	@Override
	public Item genAlea() {
		if (seraGenere())
			return new Nourriture(getNom(), getFrequence(), getUtilisations(), apport, compatibilites);
		return null;
	}
	
	public boolean estCompatible(String type) {
		for (int i = 0; i < this.compatibilites.length; i++) {
			if (type.equals(this.compatibilites[i]))
				return true;
		}

		return false;
	}
	@Override
	public String toString() {
		String compatibilites = this.compatibilites[0];
		for (int i = 1; i < this.compatibilites.length; ++i) {
			compatibilites = compatibilites + ", " + this.compatibilites[i];
		}

		return (getNom()+":"+getFrequence()+","+apport+","+getUtilisationRestantes()+"/"+getUtilisations()+","+compatibilites);
	}

	
	public void utiliser(Joueur j, int indexPokemon) {
		AncienTP.Pokemon[] sesPokemon = j.getPokemons();
		AncienTP.Pokemon mangeur = sesPokemon[indexPokemon];
		if (this.estCompatible(mangeur.getType()) && mangeur != null && sesPokemon.length>indexPokemon) {
			mangeur.baisseAppetit(this.apport);
			super.baisseUtilisations(1);
		}
		else {
			System.out.println("Votre pokemon ne pourra pas manger cette nourriture, qui n'est pas compatible avec son type.");
		}
		
	}

}
