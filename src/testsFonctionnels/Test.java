package testsFonctionnels;

import jeu.*;
import cartes.*;
import cartes.Probleme.Type;

public class Test {
	
	public static void affichage(Carte probleme) {
		StringBuilder message = new StringBuilder();
		message.append("Je pioche ");
		message.append(probleme.toString());
		System.out.println(message);
	}

	public static void main(String[] args) {
		Carte Reparation = new Parade(3,Type.ACCIDENT);
		Carte Accident = new Attaque(3,Type.ACCIDENT);
		Carte AsDuVolant = new Botte(1,Type.ACCIDENT);
		
		Sabot sabot = new Sabot();
		sabot.ajouterFamilleCarte(Accident, Reparation, AsDuVolant);
		
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		
		

	}

}
