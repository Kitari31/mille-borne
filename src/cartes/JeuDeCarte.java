package cartes;

import java.util.Iterator;
import cartes.Probleme.Type;

public class JeuDeCarte {
	private Carte[] typeDeCarte = {
	new Attaque(5, Type.FEU),
	new Parade(13,Type.FEU),
	new Botte(1,Type.FEU),
	
	new Attaque(3,Type.ACCIDENT),
	new Parade(6,Type.ACCIDENT),
	new Botte(1,Type.ACCIDENT),
	
	new Attaque(3,Type.CREVAISON),
	new Parade(6,Type.CREVAISON),
	new Botte(1,Type.CREVAISON),
	
	new Attaque(3,Type.ESSENCE),
	new Parade(6,Type.ESSENCE),
	new Botte(1,Type.ESSENCE),
	
	new Limite(4),
	new FinLimite(6),
	
	new Borne(25, 10),
	new Borne(50, 10),
	new Borne(75, 10),
	new Borne(100, 12),
	new Borne(200, 4)};
	
	private Carte[] listeCartes= new Carte[106];
	
	public JeuDeCarte() {
		int indexTab = 0;
		for (int i = 0; i < typeDeCarte.length; i++) {
			Carte famille = typeDeCarte[i];
			for (int j = 0; j < famille.getNombre() ; j++) {
				listeCartes[indexTab] = famille;
				indexTab++;
			}
		}
	}
	
	public void affichage() {
		StringBuilder message = new StringBuilder();
		for (int i = 0; i < listeCartes.length; i++) {
			message.append(listeCartes[i]);
			message.append("\n");
		}
		System.out.println(message);
	}
	
	
	public boolean checkCount() {
		for (int i = 0; i < listeCartes.length; i++) {
			if (listeCartes[i]==null) {
				return false;
			}
		}
		return true;
	}

}
