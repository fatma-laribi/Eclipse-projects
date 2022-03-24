
public class VisiteurVisiterPourPremiereFois extends Visiteur {

	public VisiteurVisiterPourPremiereFois() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void VisiterVille(Ville v) {
		System.out.println("Je visite pour la premiere fois la ville!");

	}

	@Override
	public void VisiterMuse(Muse m) {
		System.out.println("Je visite pour la premiere fois le muse!");

	}

	@Override
	public void VisiterParc(Parc p) {
		System.out.println("Je visite pour la premiere fois le parc!");

	}

}
