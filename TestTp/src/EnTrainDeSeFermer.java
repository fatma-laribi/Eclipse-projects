
public class EnTrainDeSeFermer extends Etat {
	public EnTrainDeSeFermer(PorteDeGarage p) {
		super(p);
	}
	public void etatSuivant() {
		porte.e= new Fermee(porte);
	}
	public void fermer() {	}
	public void ouvrir() {		
		System.out.println("le moteur est en train d'ouvrir la porte. ");
		this.porte.etatSuivant();
}
}
