package AncienTP;

public class PotionMagique extends Nourriture {
	
	public PotionMagique(String ingredient, int frequence) {
		super(0, ingredient, new String[]{"PLANTE", "POISON", "FEU", "DRAGON", "VOL", "EAU", "INSECTE", "NORMAL", "FONCE", "ELECTRIQUE", "TELEPATIQUE", "GLACE", "ACIER", "TERRE", "FEE", "COMBAT", "ROCHE", "FANTOME"}, frequence);
	}
	
	@Override
	public void estMangee(Pokemon mangeur) {
		super.estMangee(mangeur);
		mangeur.miseANiveau();
	}
	
	@Override
	public PotionMagique genAlea() {
		if (this.seraGenere()){
			return new PotionMagique(this.getIngredient(), this.getFrequence());
		}
		return null;
	}

}
