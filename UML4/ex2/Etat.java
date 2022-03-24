
public abstract class Etat {
PorteDeGarage porte;
	public Etat(PorteDeGarage p) {
		this.porte=p;
	}
	public void abstract fermer();
	public void abstract ouvrir();
	public void abstract etatSuivant();

}
