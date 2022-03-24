
public class EnTrainDeSouvrir extends Etat {
	public Etat etatSuivant() {
		return new Ouverte();
	}
	public void fermer() {
		System.out.println("le moteur est en train de fermer la porte. ");
	};
	public void ouvrir() {}
}
