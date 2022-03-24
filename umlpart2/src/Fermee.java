
public class Fermee extends Etat {
	public Etat etatSuivant() {
		return new EnTrainDeSouvrir();
	}
	public void fermer() {	}
	public void ouvrir() {		
		System.out.println("le moteur est en train d'ouvrir la porte. ");}
}
