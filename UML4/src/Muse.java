
public class Muse extends ZoneTouristique {

	public Muse() {
		// TODO Auto-generated constructor stub
	}

	public void accepterVisite(Visiteur v) {
		System.out.println("Le muse a accept� votre visite");

		v.VisiterMuse(this);
	}

	}

