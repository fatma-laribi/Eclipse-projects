
public class Ouverte extends Etat {
	public Ouverte(PorteDeGarage p) {
		super(p);
	}
	public Etat etatSuivant() {
		return new EnTrainDeSeFermer();
	}
	public void fermer() {	
		System.out.println("le moteur est en train de fermer la porte. ");	
		this.porte.etatSuivant();}
	public void ouvrir() {}
}
