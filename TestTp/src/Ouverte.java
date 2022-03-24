
public class Ouverte extends Etat {
	public Ouverte(PorteDeGarage p) {
		super(p);
	}
	public void etatSuivant() {
		porte.e= new EnTrainDeSeFermer(porte);
	}
	public void fermer() {	
		System.out.println("le moteur est en train de fermer la porte. ");	
		this.porte.etatSuivant();}
	public void ouvrir() {}
}
