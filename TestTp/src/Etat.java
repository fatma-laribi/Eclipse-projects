
public abstract class Etat {
PorteDeGarage porte;
	public Etat(PorteDeGarage p) {
		this.porte=p;
	}
	public abstract void fermer();
	public abstract void ouvrir();
	public abstract void etatSuivant();

}
