package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU:
			return "VEHICULE PRIORITAIRE";
		case ESSENCE:
			return "CITERNE D'ESSENCE";
		case CREVAISON:
			return "INCREVABLE";
		case ACCIDENT:
			return "AS DU VOLANT";
		default:
			throw new IllegalArgumentException("Valeur non valable: " + this.getType());
		}
	}
}
