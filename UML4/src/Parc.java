
public class Parc extends ZoneTouristique {

	public Parc() {
		// TODO Auto-generated constructor stub
	}

	public void accepterVisite(Visiteur v) {
		System.out.println("Le parc a accept� votre visite");

		v.VisiterParc(this);
	}


}
