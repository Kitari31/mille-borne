package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int nbr, int km) {
		super(nbr);
		this.km = km;
		
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

}
