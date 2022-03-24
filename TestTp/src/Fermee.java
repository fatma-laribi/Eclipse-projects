
public class Fermee extends Etat {
	public Fermee(PorteDeGarage p) {
		super(p);
	}
	public void etatSuivant() {

		porte.e= new EnTrainDeSouvrir(porte);
	}
	public void fermer() {	}
	public void ouvrir() {		
		System.out.println("le moteur est en train d'ouvrir la porte. ");
		this.porte.etatSuivant();}
}
