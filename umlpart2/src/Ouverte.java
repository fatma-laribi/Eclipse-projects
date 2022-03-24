
public class Ouverte extends Etat {
	public Etat etatSuivant() {
		return new EnTrainDeSeFermer();
	}
	public void fermer() {	
		System.out.println("le moteur est en train de fermer la porte. ");	}
	public void ouvrir() {}
}
