
public class SauceChocolat extends Toppings{

	public SauceChocolat(Produit c) {
		super(c);
	}
	public float cout() {
		return coupe.cout()+(float)0.70;
	}
	public String description() {
		return (coupe.description()+"et sa delicieuse sauce chocolat ");
	}


}