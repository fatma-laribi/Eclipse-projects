
public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Ville ville= new Ville();
		Parc p=new Parc();
		Muse m=new Muse();
		VisiteurAcheterSouvenir v1=new VisiteurAcheterSouvenir();
		VisiteurVisiterPourPremiereFois v2= new VisiteurVisiterPourPremiereFois();
		ville.accepterVisite(v2);
		m.accepterVisite(v1);
		p.accepterVisite(v2);

	}

}
