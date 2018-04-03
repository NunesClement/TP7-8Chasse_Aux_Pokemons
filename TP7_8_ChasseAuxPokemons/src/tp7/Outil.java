package tp7;

public class Outil extends Item implements ChangeItems{

	public Outil(String nom, int frequence, int utilisations) {
		super(nom, frequence, utilisations);
	}


	@Override
	public Item genAlea() {
		if (seraGenere())
			return this;
		return null;
	}

	@Override
	public void utiliser(Modifiable item) {
	if(this.getUtilisationRestantes()>0){
		this.baisseUtilisations(1);
		item.modifier();
	}
	
	}

}
