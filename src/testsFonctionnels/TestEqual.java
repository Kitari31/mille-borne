package testsFonctionnels;

import jeu.*;
import cartes.*;
import cartes.Probleme.Type;

public class TestEqual {

	public static void affichage(Carte c1, Carte c2) {
		StringBuilder message = new StringBuilder();
		message.append(c1.equals(c2));
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		Carte citerne = new Botte(1,Type.FEU);
		Carte prioritaire = new Botte(1,Type.ESSENCE);
		Carte increvable = new Botte(1,Type.CREVAISON);
		Carte asDuVolant = new Botte(1,Type.ACCIDENT);
		
		Carte feuRouge = new Attaque(1,Type.FEU);
		Carte panneEssence = new Attaque(1,Type.ESSENCE);
		Carte crevaison = new Attaque(1,Type.CREVAISON);
		Carte accident = new Attaque(1,Type.ACCIDENT);
		
		Carte feuVert = new Parade(1,Type.FEU);
		Carte essence = new Parade(1,Type.ESSENCE);
		Carte roueDeSecours = new Parade(1,Type.CREVAISON);
		Carte reparation = new Parade(1,Type.ACCIDENT);
		
		
		Carte borne10 = new Borne(10,1);
		Carte borne100 = new Borne(100,1);
		
		affichage(borne10, borne10);
		affichage(borne100, borne100);
		affichage(citerne, citerne);
		affichage(crevaison, crevaison);
		affichage(essence, essence);
		System.out.println("\n");
		affichage(borne10, citerne);
		affichage(borne10, feuRouge);
		affichage(borne10, essence);
		affichage(citerne, prioritaire);
		affichage(increvable, feuVert);
		affichage(asDuVolant, panneEssence);
		affichage(crevaison, accident);
		affichage(roueDeSecours, reparation);
	}
}
