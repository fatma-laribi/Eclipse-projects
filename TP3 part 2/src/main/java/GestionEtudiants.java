import java.util.ArrayList;

public class GestionEtudiants {
static ArrayList<Etudiant> e = new ArrayList<Etudiant>();
public GestionEtudiants() {

}
public static void ajouterEtudiant(Etudiant etudiant) {
	e.add(etudiant);
}
public static void supprimerEtudiant(int cin) {
	for( Etudiant etudiant: e) {
		if(cin==etudiant.cin) {e.remove(etudiant); break;}
	}
}
}

