import java.util.ArrayList;

public class VueCatalogueProduits {
static ArrayList<VueProduit> produits=new ArrayList<VueProduit>();;
	public VueCatalogueProduits() {
	}
	public static void ajouterProduit(VueProduit v) {
		produits.add(v);
	}

}
