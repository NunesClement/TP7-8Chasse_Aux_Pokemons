package AncienTP;
import java.util.Scanner;

public class ChasseAuxPokemons {

	public static void main(String[] args) {
		
		// nos pokemons
		final Pokemon piplup = new Pokemon("Piplup", "EAU", 5, false, 51, 53, 61, 56, new Attaque[] {new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer()});
		final Pokemon rowlet = new Pokemon("Rowlet", "PLANTE", 10, true, 55, 55, 50, 55, new Attaque[] {new AttaqueMorsure(), new AttaqueFeinte(), new AttaqueTornadeFeuilles()});
		final Pokemon totodile = new Pokemon("Totodile", "EAU", 8, false, 65, 64, 44, 48, new Attaque[] {new AttaqueBulle(), new AttaqueCoupDeTete()});

		// nos joueurs
		final Joueur jeanDupont = new Joueur("Dupont", "Jean", 20, new Pokemon[5]);
		final Joueur gabrielleMartin = new Joueur("Martin", "Gabrielle", 18, new Pokemon[5]);
				
		System.out.println(piplup);
		// Jean capture un pokemon, il le nomme "Rascal" et le donne a Gabrielle
		jeanDupont.capturer(piplup);
		jeanDupont.nommer(piplup, "Rascal");
		jeanDupont.donner(piplup, gabrielleMartin); // resultat : Jean n'a pas de pokemon, Gabrielle en a un
		jeanDupont.capturer(rowlet);
		jeanDupont.nommer(rowlet, "Fuzzy");
		jeanDupont.echanger(rowlet, gabrielleMartin, piplup);


		// TP 3
		
		// la nourriture
		final Nourriture tartiflette = new Nourriture(35, "tartiflette", new String[] {"DRAGON", "FEU", "COMBAT", "EAU", "ELECTRIQUE"}, 30);
		final Nourriture ratatouille = new Nourriture(10, "ratatouille", new String[] {"PLANTE", "EAU", "VOL", "FEU", "NORMAL", "ELECTRIQUE", "COMBAT"}, 30); 

		// TP 4
		
		final Gourmandise barreChocolatee = new Gourmandise(20, "Barre Chocolatee", new String[] {"DRAGON", "FEU", "COMBAT", "EAU", "ELECTRIQUE"}, 10, 5, 7);
		final PotionMagique mojito = new PotionMagique("mojito", 2);
		
		
		// TP 5
		jeanDupont.addNourriture(mojito);
		jeanDupont.addNourriture(barreChocolatee);
		jeanDupont.capturer(totodile);
		jeanDupont.nommer(totodile, "Schnappi");

		
		// TP 6
		// une bataille entre piplup et rowlet

		Scanner lecteur = new Scanner(System.in);
		System.out.println();
		
		final Pokemon p1 = piplup;
		final Pokemon p2 = rowlet;
		
		boolean batailleFinie = false;
	
		while (!batailleFinie) {
			if (p1.sEstEvanoui() || p2.sEstEvanoui()) {
				batailleFinie = true;
			}
			if(!batailleFinie) {
				p1.regarderAttaques();
				System.out.println("Pour pokemon" +p1.getNom() + ", choisissez l'index de votre attaque contre le pokemon " + p2.getNom());
				int reponseIndex = lecteur.nextInt();
				while (reponseIndex < 0 || reponseIndex > p1.getSesAttaques().length) {
					System.out.println("Refaites votre choix.");
					reponseIndex = lecteur.nextInt();
				}
				p1.utiliseAttaque(reponseIndex, p2);
				if (p2.sEstEvanoui()) {
					batailleFinie = true;
				}
			}
			
			if(!batailleFinie && !p2.sEstEvanoui()) {
				p2.regarderAttaques();
				System.out.println("Pour pokemon" +p2.getNom() + ", choisissez l'index votre attaque contre le pokemon " + p1.getNom());
				int reponseIndex = lecteur.nextInt();
				while (reponseIndex < 0 || reponseIndex > p2.getSesAttaques().length) {
					System.out.println("Refaites votre choix.");
					reponseIndex = lecteur.nextInt();
				}
				p2.utiliseAttaque(reponseIndex, p1);
				if (p1.sEstEvanoui()) {
					batailleFinie = true;
				}
			}
		}

		if (p1.sEstEvanoui()) {
			System.out.println("Le vainqueur est " + p2.getNom());
		}
		else {
			System.out.println("Le vainqueur est " + p1.getNom());
		}
		
		p1.resetAttaques();
		p2.resetAttaques();
/*
		// TP 5, commente dans TP 6
	
		// plus de pokemons
		final Pokemon piplup2 = new Pokemon("Piplup", "EAU", 5, false);
		final Pokemon rowlet2 = new Pokemon("Rowlet", "PLANTE", 10, true);
		final Pokemon totodile2 = new Pokemon("Totodile", "EAU", 8, false);
		final Joueur moi = new Joueur("Onete", "Cristina", 20, new Pokemon[5]);
		moi.capturer(totodile2);
		moi.capturer(piplup2);
		moi.capturer(rowlet2);
*/
		
/*		
		// une carotte 
		final Nourriture carotte = new Nourriture(2, "carotte", new String[] {"PLANTE", "TERRE", "VOL"}, 60);
		System.out.println(carotte);
		
		Scanner lecteur = new Scanner(System.in);
		System.out.println();

		String reponse = "";
		int index;
		
		while (!reponse.equals("stop")) {

			// interaction 1 : regarder ses pokemons
			System.out.println("Voulez-vous regarder vos pokemons ? Tapez <<oui>> ou <<non>>.");
			reponse = lecteur.next();
			while (!reponse.equals("non") && !reponse.equals("oui")) {
				System.out.println("Refaites votre choix. Tapez <<oui>> ou << non >>.");
				reponse = lecteur.next();
			}
			if (reponse.equals("oui")) {
				System.out.println(moi.afficherPokemons());
				System.out.println("Lequel de vos pokemons voulez-vous regarder ? Tapez son index ou tapez <<non>> pour passer a la prochaine etape.");
				reponse = lecteur.next();
				while(!reponse.equals("non")) {
					System.out.println(moi.getPokemons()[Integer.parseInt(reponse)]);
					System.out.println("Voulez-vous regarder un autre pokemon ? Tapez son index ou tapez <<non>> pour passer a la prochaine etape");
					reponse = lecteur.next();
				}
			}
			
			// interaction 2 : regarder sa caisse nourriture
			System.out.println("Voulez-vous regarder votre caisse nourriture ? Tapez <<oui>> ou <<non>>.");
			reponse = lecteur.next();
			while (!reponse.equals("non") && !reponse.equals("oui")) {
				System.out.println("Refaites votre choix. Tapez <<oui>> ou << non >>.");
				reponse = lecteur.next();
			}
			if (reponse.equals("oui")) {
				System.out.println(moi.contenusCaisse());
			}
			
			// interaction 3 : nourrir des pokemons
			System.out.println("Voulez-vous nourrir vos pokemons ? Tapez <<oui>> ou <<non>>.");
			reponse = lecteur.next();
			while (!reponse.equals("non") && !reponse.equals("oui")) {
				System.out.println("Refaites votre choix. Tapez <<oui>> ou << non >>.");
				reponse = lecteur.next();
			}
			if (reponse.equals("oui")) {
				System.out.println("Lequel de vos pokemons voulez-vous nourrir ? Tapez son index ou tapez <<non>> pour passer a la prochaine etape.");
				reponse = lecteur.next();
				while(!reponse.equals("non")) {
					index = Integer.parseInt(reponse);
					System.out.println("Donnez l'index (dans la caisse) de la nourriture que vous voulez donner a votre pokemon ou tapez <<non>> pour passer a la prochaine etape.");
					reponse = lecteur.next();
					if (!reponse.equals("non")) {
						moi.nourrirPokemon(moi.getPokemons()[index], Integer.parseInt(reponse));
					}
				}
			}

			
			// interaction 4 : generer/collectionner nourriture
			Nourriture n = carotte.genAlea();
			if (n == null) {
				System.out.println("Vous n'avez rien trouve. Si vous voulez vous arreter, tapez << stop >> . Sinon, tapez << non >> .");
				reponse = lecteur.next();
				while (!reponse.equals("non") && !reponse.equals("stop")) {
					System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
					reponse = lecteur.next();
				}
			} else {
				System.out.println("Vous avez trouve un(e) " + n.getIngredient() + ".");
				System.out.println("Voulez vous la prendre ? << oui / non / stop>>");
				reponse = lecteur.next();
				
				while (!reponse.equals("oui") && !reponse.equals("non") && !reponse.equals("stop")) {
					System.out.println("Repetez votre choix s.v.p. Il faut taper << oui >>, << non >> ou << stop >>");
					reponse = lecteur.next();
				}

				if (reponse.equals("oui")) {
					moi.addNourriture(n);
					System.out.println("Voulez-vous vous arreter ? Tapez << stop >>. Sinon, tapez << non >>");
					reponse = lecteur.next();
					while (!reponse.equals("non") && !reponse.equals("stop")) {
						System.out.println("Refaites votre choix. Tapez << stop >> ou << non >>");
						reponse = lecteur.next();
					}
				}
					
			}


			System.out.println();
		}
*/	

	}

}
