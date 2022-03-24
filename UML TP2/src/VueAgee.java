
public class VueAgee implements Strategy {
	public static String police="grande police"; 

	public VueAgee() {
		
	}

	@Override
	public void afficher() {
		for(VueProduit p: VueCatalogueProduits.produits) {
			p.affiche();
			System.out.println();
			
		}

	}

}
