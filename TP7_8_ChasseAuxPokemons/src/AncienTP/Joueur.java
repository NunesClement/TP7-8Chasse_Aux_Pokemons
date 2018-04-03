package AncienTP;

public class Joueur {
	private String nom;
	private String prenom;
	private int age;
	private Pokemon[] pokemons;
	private Nourriture[] caisseNourriture;

	public Joueur(String nom, String prenom, int age, Pokemon pokemons[]) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.pokemons = pokemons;
		this.caisseNourriture = new Nourriture[10];
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}
	
	public Pokemon[] getPokemons() {
		return this.pokemons;
	}
	
	// TP 5
	public Nourriture[] getCaisseNourriture() {
		return this.caisseNourriture;
	}
	
	// methode rend -1 si pas de place ou la place (entre 0 et 9) si on a de la place
	public int premierePlaceLibre() {
		int premierePlace = -1; // =pas de place
		int i = 0;
		
		while (premierePlace == -1 && i<this.caisseNourriture.length) {
			if (null == this.caisseNourriture[i])
				premierePlace = i;
			i++;
		}
		
		return premierePlace;
		
	}

	
	public boolean aLaPlace() {
		
		if (this.premierePlaceLibre() == -1){
			return false;
		}

		return true;
	}

	public void addNourriture(Nourriture n) {
		int premierePlace = this.premierePlaceLibre();
		if (premierePlace == -1)
			System.out.println("Vous n'avez plus de place dans votre caisse pour cette nourriture. Lachez ou utilisez une autre nourriture.");	
		else {
			this.caisseNourriture[premierePlace] = n;
		}
	}
	
	public String contenusCaisse() {
		String contenus = "";
		
		for(int i = 0; i < this.caisseNourriture.length; i++) {
			if (null != this.caisseNourriture[i]) {
				contenus += i + " : " + this.caisseNourriture[i].getIngredient() + "\n";
			}
		}
		
		if (contenus.equals(""))
			System.out.println("Caisse vide.");
		
		return contenus;
	}
	
	public void lacherNourriture(int index) {
		if (index < 0 || index >= this.caisseNourriture.length) {
			System.out.println("Il faut choisir un index entre 0 et " + this.caisseNourriture.length);
		}
		else {
			if (null == this.caisseNourriture[index])
				System.out.println("Rien a lacher la.");
			else
				this.caisseNourriture[index] = null;
		}
	}
	
	public void regarderPokemon(Pokemon p) {
		boolean regarde = false;
		int i = 0;
		
		while (!regarde && i < this.pokemons.length) {
			if (p == this.pokemons[i]) {
				regarde = true;
				System.out.println(p);
			}
			i++;
		}
		
		if(!regarde) {
			System.out.println("Vous n'etes pas le maitre de ce pokemon !");
		}
	}
	
	public void nourrirPokemon(Pokemon p, int index) {
		if (null == this.caisseNourriture[index]) {
			System.out.println("Il n'y a pas de nourriture a cette position de votre caisse.");
		}
		else {
			boolean nourri = false;
			int i = 0;
			while (!nourri && i<this.pokemons.length) {
				if (p == this.pokemons[i]) {
					nourri = true;
					p.mange(this.caisseNourriture[index]);
					if (this.caisseNourriture[index].estCompatible(p.getType()))
						this.lacherNourriture(index);
				}
				i++;
			}
			if (!nourri) {
				System.out.println("Vous ne pouvez nourrir ce pokemon puisque vous n'etes pas son maitre.");
			}
		}
	}
	
	public String afficherPokemons() {
		String mesPokemons = "";
		for (int i = 0; i<this.pokemons.length; i++) {
			if (null != this.pokemons[i]) {
				mesPokemons += i + " : " + this.pokemons[i] + "\n";
			}
		}
		return mesPokemons;
	}
	
	// TP2
	public void capturer(Pokemon p) {
		boolean capture = false;
		int i = 0;
		
		if (p.getMonJoueur() != null) {
			System.out.println("Vous ne pouvez pas capturer un pokemon qui a deja un maitre.");
		}
		else{
			while (!capture && i < this.pokemons.length) {
				if (this.pokemons[i] == null && !capture) {
					this.pokemons[i] = p;
					p.setMonJoueur(this);
					
					// TP3
					p.estCapture();
					
					// TP2
					capture = true;
				}
				i++;
			}
			if (!capture) {
				System.out.println("Vous ne pouvez pas capturer le pokemon " + p.getNom() + " puisque vous avez deja 5 pokemons !");
			}
		}
	}
	

	public void liberer(Pokemon p) {
		boolean libere = false;
		int i = 0;
		
		while (!libere && i < this.pokemons.length) {
			if ((this.pokemons[i] == p)) {
				this.pokemons[i] = null;
				p.setNomDonne(null);
				p.setMonJoueur(null);
				
				// TP3
				p.estLibere();
				
				// TP2
				libere = true;
			}
			i++;
		}
		
		if (!libere) {
			System.out.println("Vous ne pouvez pas liberer ce pokemon puisque vous n'etes pas son maitre.");
		}
	}

	public void nommer(Pokemon p, String nom) {
		if (p.getMonJoueur() == this) {
			p.setNomDonne(nom);
		}
		else {
			System.out.println("Vous ne pouvez pas nommer ce pokemon puisque vous n'etes pas son maitre !");
		}
		
	}

	public void donner(Pokemon p, Joueur autreJoueur) {
		boolean donne = false;
		int i = 0;
		while (!donne && i < this.pokemons.length) {
			if (this.pokemons[i] == p) {
				int j = 0;
				while (!donne && j < autreJoueur.pokemons.length) {
					if (autreJoueur.pokemons[j] == null) {
						this.pokemons[i] = null;
						autreJoueur.pokemons[j] = p;
						p.setMonJoueur(autreJoueur);
						donne = true;
					}
					j++;
				}
				
				if (! donne) {
					System.out.println("Vous ne pouvez pas donner ce pokemon a " + autreJoueur.prenom + " puisqu'il a deja 5 pokemons dans son entourage !");
				}
				
			}
			i++;
		}
		
		if (! donne) {
			System.out.println("Vous ne pouvez pas donner ce pokemon puisque vous n'etes pas son maitre !");
		}
		
	}

	public void echanger(Pokemon p, Joueur autreJoueur, Pokemon autrePokemon) {
		boolean echange = false;
		int i = 0;
		while (!echange && i < this.pokemons.length) {
			if (this.pokemons[i] == p) {
				int j = 0;
				while (!echange && j < autreJoueur.pokemons.length) {
					if (autreJoueur.pokemons[j] == autrePokemon) {

						pokemons[i] = autrePokemon;
						autreJoueur.pokemons[j] = p;

						p.setMonJoueur(autreJoueur);
						autrePokemon.setMonJoueur(this);
						echange = true;
					}
					j++;
				}
				if (! echange) {
					System.out.println("Vous ne pouvez pas echanger ce pokemon avec " + autreJoueur.prenom + " puisque " + autreJoueur.nom + " n'est pas le maitre du pokemon que vous souhaitez !");
				}
				
			}
			i++;
		}
		if (! echange) {
			System.out.println("Vous ne pouvez pas echanger ce pokemon avec " + autreJoueur.prenom + " puisque vous n'etes pas son maitre !");
		}
	}

}
