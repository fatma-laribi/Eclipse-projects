
public class EnTrainDeSouvrir extends Etat {
	public EnTrainDeSouvrir(PorteDeGarage p) {
		super(p);
	}
	public Etat etatSuivant() {
		return new Ouverte();
	}
	public void fermer() {
		System.out.println("le moteur est en train de fermer la porte. ");
		this.porte.etatSuivant();
	};
	public void ouvrir() {}
}
