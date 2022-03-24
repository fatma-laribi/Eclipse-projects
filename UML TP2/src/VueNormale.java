
public class VueNormale implements Strategy {
	public static String police="taille normale"; 
	public VueNormale() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afficher() {
		int i=0;
		for(VueProduit p: VueCatalogueProduits.produits) {
			p.affiche();
			System.out.print(" ");
			i++;
			if (i%3==0) {System.out.println();}
			
		}

	}

}
