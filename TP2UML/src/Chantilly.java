
public class Chantilly extends Toppings{

	public Chantilly(Produit c) {
		super(c);
	}
	public float cout() {
		return coupe.cout()+(float)0.5;
	}
	public String description() {
		return (coupe.description()+"chantilly ");
	}


}
