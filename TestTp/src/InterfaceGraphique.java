
public class InterfaceGraphique implements Observateur{
PorteDeGarage g;
	public InterfaceGraphique(PorteDeGarage g) {
		this.g=g;
		System.out.println("Interface en marche. Porte: "+g.e.getClass().getName());
	}

	@Override
	public void actualiser() {
		System.out.println("Etat change. La porte est maintenant "+ g.e.getClass().getName());
		
	}
	

}
