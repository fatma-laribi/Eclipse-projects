import java.util.ArrayList;

public class Ville extends ZoneTouristique {
ArrayList<ZoneTouristique> zone;
	public Ville() {
		zone=new ArrayList<ZoneTouristique>();
	}
	public void ajouter(ZoneTouristique z) {
		zone.add(z);
	}
	public void accepterVisite(Visiteur v) {
		System.out.println("La ville a accepté votre visite");
		v.VisiterVille(this);
		for(int i=0;i<zone.size();i++) {
			zone.get(i).accepterVisite(v);}
	}
	

}
