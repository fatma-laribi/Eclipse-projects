
public class EnTrainDeSeFermer extends Etat {
	public EnTrainDeSeFermer(PorteDeGarage p) {
		super(p);
	}
	public Etat etatSuivant() {
		return new Fermee();
	}
	public void fermer() {	}
	public void ouvrir() {		
		System.out.println("le moteur est en train d'ouvrir la porte. ");
		this.porte.etatSuivant();
}
}
