
public class PorteDeGarage extends Sujet{
Etat e= new Fermee(this);
	public PorteDeGarage() {
		// TODO Auto-generated constructor stub
	}
	public void fermer() {e.fermer();}
	public void ouvrir() {e.ouvrir();}
	public void etatSuivant() {e.etatSuivant(); this.notifier();}
}
