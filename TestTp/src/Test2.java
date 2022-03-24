

public class Test2 {

	public Test2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		PorteDeGarage g=new PorteDeGarage();
		InterfaceGraphique i=new InterfaceGraphique(g);
		g.ajouter(i);
		g.ouvrir();

	}

}
