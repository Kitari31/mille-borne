package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterator<Carte>{
	private Carte[] tabCartes;
	private int nbCartes;
	private int indiceIterateur;
	private boolean nextEffectue;
	private int nbCartesReference;

			
	public Sabot() {
		this.tabCartes = new Carte[110]; 
		this.nbCartes = 0;
		this.indiceIterateur = 0;
		this.nextEffectue = false;
		this.nbCartesReference = 0;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte carte) {
		if(nbCartes ==110) {
			throw new ArrayIndexOutOfBoundsException();
		}else {
			tabCartes[nbCartes] = carte;
			nbCartes++;
			nbCartesReference++;
		}
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		int nbrFamille = carte.getNombre();
		for (int i = 0; i < nbrFamille; i++) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte(Carte... args) {
		for (Carte carte : args){
			ajouterFamilleCarte(carte);
		}
	}

	public Carte piocher() {
		if(!estVide()) {
			Carte carte = tabCartes[indiceIterateur];
			remove();
			if(hasNext()) {
				next();
			}
			return carte;
		}else {
			throw new IllegalStateException();
		}
	}
	
	
	public void verifOccurrence() {
		if(nbCartes != nbCartesReference) {
			throw new ConcurrentModificationException();
		}
	}

	@Override
	public boolean hasNext() {
		nextEffectue = false;
		return nbCartes < 110;
	}

	@Override
	public Carte next() {
		verifOccurrence();
		if(!hasNext()) {
			throw new NoSuchElementException();
		}else{
			indiceIterateur++;
			nextEffectue = true;
			return tabCartes[indiceIterateur];
		}
	}
	
	@Override
	public void remove() {
		verifOccurrence();
		if(nbCartes < 1) {
			throw new IllegalStateException();
		}else {
			tabCartes[indiceIterateur] = null;
			nextEffectue = false;
			nbCartes--;
			nbCartesReference--;
		}
		
	}
}	
