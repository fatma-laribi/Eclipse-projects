
public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		VueCatalogueProduits v= new VueCatalogueProduits();
		v.ajouterProduit(new VueProduit("Produit 1"));
		v.ajouterProduit(new VueProduit("Produit 2"));
		v.ajouterProduit(new VueProduit("Produit 3"));
		v.ajouterProduit(new VueProduit("Produit 4"));
		v.ajouterProduit(new VueProduit("Produit 5"));

		System.out.println("Vue Normale: \n");
		Context c= new Context();
		c.setVue(new VueNormale());
		c.executeStrategy();
		
		System.out.println("\n*************");
		
		System.out.println("Vue Agee: \n");
		c.setVue(new VueAgee());
		c.executeStrategy();}}
