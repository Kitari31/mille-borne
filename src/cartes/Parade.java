package cartes;

public class Parade extends Bataille {

	public Parade(int nbr, Type type) {
		super(nbr, type);
	}

	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "FEU VERT";
		}
		case ESSENCE: {
			return "ESSENCE";
		}
		case CREVAISON: {
			return "ROUE DE SECOURS";
		}
		case ACCIDENT: {
			return "RÉPARATIONS";
		}
		default:
			throw new IllegalArgumentException("Valeur non valable: " + this.getType());
		}
	}
}
