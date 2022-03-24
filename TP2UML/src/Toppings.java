
public class Toppings extends CoupeGlacee{
protected Produit coupe;
	public Toppings(Produit c) {
			super();
			this.coupe=c;	}
	public float cout() {
		return coupe.cout();
	}
	public String description() {
		return (super.description());
	}

}
