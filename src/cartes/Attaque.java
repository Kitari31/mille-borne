package cartes;

public class Attaque extends Bataille {

	public Attaque(int nbr, Type type) {
		super(nbr, type);
	}
	
	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "FEU ROUGE";
		}
		case ESSENCE: {
			return "PANNE D'ESSENCE";
		}
		case CREVAISON: {
			return "CREVAISON";
		}
		case ACCIDENT: {
			return "ACCIDENT";
		}
		default:
			throw new IllegalArgumentException("Valeur non valable: " + this.getType());
		}
	}

}
