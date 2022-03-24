

import java.util.ArrayList;

public class Sujet {
ArrayList<Observateur> o;
	public Sujet() {
		o=new ArrayList<Observateur>();
	}
	public void ajouter(Observateur o2) {o.add(o2);}
	public void supprimer(Observateur o2) {o.remove(o2);}
	public void notifier() {
		for(int i=0;i<o.size();i++) {
			o.get(i).actualiser();
	}}
}
