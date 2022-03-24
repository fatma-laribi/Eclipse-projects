
public class PorteDeGarage {
Etat e= new Fermee();
	public PorteDeGarage() {
		// TODO Auto-generated constructor stub
	}
	public void fermer() {e.fermer();}
	public void ouvrir() {e.ouvrir();}
	public void etatSuivant() {e=e.etatSuivant();}
}
