package jeu;
import cartes.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterator<Carte>{
	private Carte [] tableauDeCartes;
	private int nbCartes;
	private int indiceIterator;
	private boolean nextEffectue;
	private int nbCartesReference;
	private int nombreOperations = 0;
	

	public Sabot() {
		this.tableauDeCartes = new Carte[110];
		this.indiceIterator =0;
		this.nextEffectue = false;
		this.nbCartes = 0;
		this.nbCartesReference = 0;
	}
	
	public boolean estVide() {
		return nbCartes ==0;
	}
	
	private void ajouterCarte(Carte carte) {
		if(nbCartes ==110) {
			throw new ArrayIndexOutOfBoundsException();
		}else {
			tableauDeCartes[nbCartes] = carte;
			nbCartes++;
			nbCartesReference++;
		}
		nombreOperations++;
	}
	
	//C'est une surcharge avec les plusieurs cartes
	public void ajouterFamilleCarte(Carte carte) {
		int nbrFamille = carte.getNombre();
		for (int i = 0; i < nbrFamille; i++) {
			ajouterCarte(carte);
		}
	}
	
	//Varargs
	public void ajouterFamilleCarte(Carte... args) {
		for (Carte carte : args){
			ajouterFamilleCarte(carte);
		}
	}
	
	public Carte piocher() {
		if(!estVide()) {
			Carte carte = tableauDeCartes[indiceIterator];
			if(hasNext()) {
				next();
				remove();
				return carte;
			}
		}
		throw new IllegalStateException("liste vide");
	}

	public void verifOccurrence() {
		if(nbCartes != nbCartesReference) {
			throw new ConcurrentModificationException();
		}
	}

	@Override
	public boolean hasNext() {
		nextEffectue = false;
		return indiceIterator < 110;
	}

	@Override
	public Carte next() {
		verifOccurrence();
		if(!hasNext()) {
			throw new NoSuchElementException();
		}else{
			indiceIterator++;
			nextEffectue = true;
			return tableauDeCartes[indiceIterator];
		}
	}
	
	@Override
	public void remove() {
		verifOccurrence();
		if(nbCartes < 1 || !nextEffectue) {
			throw new IllegalStateException();
		}else {
			tableauDeCartes[indiceIterator-1] = null;
			nextEffectue = false;
			nbCartes--;
			nbCartesReference--;
		}
		
	}

}