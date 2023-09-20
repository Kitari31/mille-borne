package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterator<Carte>{
	private Carte[] tabCartes;
	private int nbCartes;
	private int indiceIterateur;
	private boolean nextEffectue;

			
	public Sabot() {
		this.tabCartes = new Carte[110]; 
		this.nbCartes = 0;
		this.indiceIterateur = 0;
		this.nextEffectue = false;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte carte) {
		if (nbCartes >= 110)
			throw new ArrayIndexOutOfBoundsException("Maximum de cartes atteint");
		tabCartes[nbCartes] = carte;
		nbCartes++;
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		int nbrCarteFamille = carte.getNombre();
		for (int i = 0; i < nbrCarteFamille; i++) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte(Carte... args) {
		for(Carte carte : args) {
			ajouterFamilleCarte(carte);
		}
	}

	public Carte piocher() {
		if(!estVide()) {
			Carte carte = tabCartes[nbCartes];
			remove();
			if(hasNext()) {
				next();
			}
			return carte;
		}else {
			throw new IllegalStateException();
		}
	}
	
	@Override
	public boolean hasNext() {
		return nbCartes < 110;
	}

	@Override
	public Carte next() {
		if(hasNext()) {
			Carte carte = tabCartes[nbCartes];
			indiceIterateur++;
			nextEffectue = true;
			return carte;
		}else {
			throw new NoSuchElementException();
		}
	}
	
	@Override
	public void remove() {
		if(nbCartes < 1 || !nextEffectue) {
			throw new IllegalStateException();
		}
		for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
			tabCartes[i] = tabCartes[i+1];
		}
		nextEffectue = false;
		indiceIterateur--;
		nbCartes--;
	}
}	
