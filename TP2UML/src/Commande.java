import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class Commande {
public List<Produit> lesProduits;
	public Commande() {
		lesProduits=new ArrayList<Produit>();
	}
	public void add(CoupeGlacee c) {
		lesProduits.add(c);
	}
	public void publieFacture(PrintWriter writer) {
		float total = 0;
		for (Iterator it = this.lesProduits.iterator(); it.hasNext();) {
		Produit product = (Produit) it.next();
		writer.println(product.description()+" + "+product.cout());
		total = total + product.cout();
		}
		writer.println(" TOTAL : "+total);
		}

}
