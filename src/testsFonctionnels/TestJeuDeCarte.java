package testsFonctionnels;

import  cartes.*;

public class TestJeuDeCarte {
	
	public static void main(String[] args) {
		JeuDeCarte jeuDeCartes = new JeuDeCarte();
		
		System.out.println(jeuDeCartes.checkCount());
		System.out.println("\n");
		jeuDeCartes.affichage();
	
	}

}