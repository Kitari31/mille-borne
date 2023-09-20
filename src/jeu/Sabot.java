package jeu;

import cartes.Carte;

public class Sabot {
	private Carte[] tabCartes;
	private int nbCartes;
			
	public Sabot() {
		this.tabCartes = new Carte[110]; 
		this.nbCartes = 0;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if(nbCartes >= 110) {
			throw new ArrayIndexOutOfBoundsException("Il y'a déjà un nombre maximum de Cartes");
		}
		tabCartes[nbCartes] = carte;
		nbCartes++;
	}
}
