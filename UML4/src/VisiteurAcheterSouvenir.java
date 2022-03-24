
public class VisiteurAcheterSouvenir extends Visiteur {

	public VisiteurAcheterSouvenir() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void VisiterVille(Ville v) {
		System.out.println("J'achete un souvenir de la ville");

	}

	@Override
	public void VisiterMuse(Muse m) {
		System.out.println("J'achete un souvenir du muse");

	}

	@Override
	public void VisiterParc(Parc p) {
		System.out.println("J'achete un souvenir du parc");

	}

}
